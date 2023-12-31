package com.example.studyspringboot.service;

import com.example.studyspringboot.entity.UserInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserInfoService {
    /**
     * 查询所有
     *
     * @return 所有用户
     */
    PageInfo<UserInfo> selectAll(Integer pageNum, Integer pageSize);

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
     * @param userInfo 用户信息
     * @return 成功操作数量
     */
    Integer updateUserById(UserInfo userInfo);
}
