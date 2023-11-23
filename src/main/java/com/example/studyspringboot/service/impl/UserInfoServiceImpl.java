package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.dao.UserInfoMapper;
import com.example.studyspringboot.entity.Result;
import com.example.studyspringboot.entity.UserInfo;
import com.example.studyspringboot.exception.AppException;
import com.example.studyspringboot.exception.AppExceptionCodeMsg;
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
        UserInfo u = selectByName(userInfo.getName());
        if (u != null) {
            throw new AppException(AppExceptionCodeMsg.USERNAME_ALREADY_EXISTS);
        }
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
