package com.example.studyspringboot.dao;

import com.example.studyspringboot.entity.Userdetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author weekend
* @description 针对表【UserDetails】的数据库操作Mapper
* @createDate 2024-03-27 21:11:29
* @Entity com.example.studyspringboot.entity.Userdetails
*/
@Mapper
public interface UserdetailsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Userdetails record);

    int insertAll(List<Userdetails> records);

    int insertSelective(Userdetails record);

    Userdetails selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Userdetails record);

    int updateByPrimaryKey(Userdetails record);

}
