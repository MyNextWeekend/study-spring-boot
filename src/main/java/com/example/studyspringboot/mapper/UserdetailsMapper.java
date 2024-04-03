package com.example.studyspringboot.mapper;

import com.example.studyspringboot.entity.Userdetails;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
* @author weekend
* @description 针对表【UserDetails】的数据库操作Mapper
* @createDate 2024-04-03 20:11:02
* @Entity com.example.studyspringboot.entity.Userdetails
*/
public interface UserdetailsMapper {
    int insertBatch(@Param("userdetailsCollection") Collection<Userdetails> userdetailsCollection);

}




