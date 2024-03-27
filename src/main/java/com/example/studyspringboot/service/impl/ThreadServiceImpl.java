package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.dao.UserdetailsMapper;
import com.example.studyspringboot.entity.Userdetails;
import com.example.studyspringboot.service.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 线程服务impl
 *
 * @author weekend
 * @date 2024/03/15
 */
@Slf4j
@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private UserdetailsMapper userdetailsMapper;

    @Async("asyncPoolTaskExecutor")
    @Override
    public void test01() {
        try {
            log.info("异步任务开始执行");
            Thread.sleep(3000);
            log.info("异步任务执行结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 有返回值的异步方法
     */
    @Async("asyncPoolTaskExecutor")
    @Override
    public CompletableFuture<String> test02() {
        try {
            log.info("异步任务开始执行");
            Thread.sleep(3000);
            log.info("异步任务执行结束");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture("async ok");
    }

    public void addUserDetail() {
        List<Userdetails> userdetails = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Userdetails userdetail = new Userdetails();
            userdetail.setUserId(i);
            userdetail.setAge(i);
            userdetail.setFullName("" + i);
            userdetail.setEmail("" + i);
            userdetail.setRegistrationDate(new Date());
            userdetail.setLastLoginDate(new Date());
            userdetail.setPhoneNumber("" + i);
            userdetail.setProfileDescription("" + i);
            userdetail.setAccountExpiryDate(new Date());
            userdetails.add(userdetail);
        }
        int res = userdetailsMapper.insertAll(userdetails);
        if (1 != res) {
            log.error("插入失败");
        }
        log.info("插入成功");
        for (Userdetails userdetail : userdetails) {
            log.info("插入id:{}", userdetail.getId());
            log.info("插入userId:{}", userdetail.getUserId());
            log.info("插入fullName:{}", userdetail.getFullName());
        }
    }
}
