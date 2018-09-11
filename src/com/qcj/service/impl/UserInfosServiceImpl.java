package com.qcj.service.impl;

import com.qcj.mapper.UserInfosMapper;
import com.qcj.pojo.UserInfos;
import com.qcj.service.UserInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userInfosService")
public class UserInfosServiceImpl implements UserInfosService {
    @Autowired
    private UserInfosMapper userInfosMapper;//用spring创建对象

    @Override
    public List<UserInfos> queryAll() {
        return userInfosMapper.queryAll();
    }

    @Override
    public int insertUser(UserInfos userInfos) {
        return userInfosMapper.insertUser(userInfos);
    }

    @Override
    public int updateUser(UserInfos userInfos) {
        return userInfosMapper.updateUser(userInfos);
    }

    @Override
    public int deleteUser(int uid) {
        return userInfosMapper.deleteUser(uid);
    }
}
