package com.example.studyspringboot;

import com.example.studyspringboot.dto.RegisterResultDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@SpringBootTest
@Slf4j
public class HttpTest {
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void test01() {
        String url = "http://106.55.186.222:8000/user/register";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("userName", "admin");
        hashMap.put("password", "463813129514088");
        hashMap.put("password2", "463813129514088");
        hashMap.put("nickName", "蔡艳");
        try {
            ResponseEntity<RegisterResultDto> responseEntity = restTemplate.postForEntity(url, hashMap, RegisterResultDto.class);
            log.info("Status Code: {}", responseEntity.getStatusCode());
            if(200 == responseEntity.getStatusCodeValue()){
                RegisterResultDto body = responseEntity.getBody();
                log.info("Body: {}", body);
                if(body!=null){
                    log.info("Code: {}", body.getCode());
                    log.info("Message: {}", body.getMessage());
                    log.info("Data: {}", body.getData());
                    RegisterResultDto.DataDTO data = body.getData();
                    if(data!=null){
                        log.info("userId: {}", data.isOk());
                    }
                }
            }
        } catch (HttpClientErrorException | HttpServerErrorException | ResourceAccessException e) {
            log.error("Error occurred while making the REST call", e);
        }


    }
}
