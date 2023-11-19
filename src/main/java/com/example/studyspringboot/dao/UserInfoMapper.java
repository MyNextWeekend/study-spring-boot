package com.example.studyspringboot.dao;

import com.example.studyspringboot.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


//@Repository
@Mapper
public interface UserInfoMapper {
    /**
     * 查询所有
     *
     * @return 所有用户
     */
    List<UserInfo> selectAll();

    /**
     * 查询用户名是否存在
     *
     * @param name 用户名
     * @return 存在条数
     */
    UserInfo selectByName(String name);

    /**
     * 存入
     *
     * @param userInfo 用户
     * @return 成功数量
     */
    Integer insertUser(UserInfo userInfo);

    /**
     * 通过id删除用户
     *
     * @param id 用户id
     * @return 成功操作数量
     */
    Integer deleteUserById(Integer id);

    /**
     * 通过id修改数量
     *
     * @param userInfo 新的用户信息
     * @return 成功操作数量
     */
    Integer updateUserById(UserInfo userInfo);
}
