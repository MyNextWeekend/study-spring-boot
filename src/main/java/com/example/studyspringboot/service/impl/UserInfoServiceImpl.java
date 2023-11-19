package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.dao.UserInfoMapper;
import com.example.studyspringboot.entity.UserInfo;
import com.example.studyspringboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public UserInfo selectByName(String name) {
        return userInfoMapper.selectByName(name);
    }

    @Override
    public Integer insertUser(UserInfo userInfo) {
        return userInfoMapper.insertUser(userInfo);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userInfoMapper.deleteUserById(id);
    }

    @Override
    public Integer updateUserById(UserInfo userInfo) {

        return userInfoMapper.updateUserById(userInfo);
    }
}
