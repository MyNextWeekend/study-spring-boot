package com.example.studyspringboot.service.impl;

import com.example.studyspringboot.dao.UserInfoMapper;
import com.example.studyspringboot.entity.UserInfo;
import com.example.studyspringboot.exception.AppException;
import com.example.studyspringboot.exception.ReturnCodeMsg;
import com.example.studyspringboot.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public PageInfo<UserInfo> selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize); // 开启分页查询
        List<UserInfo> userInfos = userInfoMapper.selectAll(); //正常查询分页 （注意sql语句结尾不能写分号）
        return new PageInfo<>(userInfos); // 返回一个PageInfo对象，包含更详细的分页信息
    }

    @Override
    public UserInfo selectByName(String name) {
        return userInfoMapper.selectByName(name);
    }

    @Override
    public Integer insertUser(UserInfo userInfo) {
        UserInfo u = selectByName(userInfo.getName());
        if (u != null) {
            throw new AppException(ReturnCodeMsg.USERNAME_ALREADY_EXISTS);
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
