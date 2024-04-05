package com.example.studyspringboot.mapper;

import com.example.studyspringboot.entity.Userdetails;

/**
* @author weekend
* @description 针对表【UserDetails】的数据库操作Mapper
* @createDate 2024-04-05 11:03:23
* @Entity com.example.studyspringboot.entity.Userdetails
*/
public interface UserdetailsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Userdetails record);

    int insertSelective(Userdetails record);

    Userdetails selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Userdetails record);

    int updateByPrimaryKey(Userdetails record);

}
