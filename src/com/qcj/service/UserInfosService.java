package com.qcj.service;

import com.qcj.pojo.UserInfos;

import java.util.List;

public interface UserInfosService {
    List<UserInfos> queryAll();
    int insertUser(UserInfos userInfos);
    int updateUser(UserInfos userInfos);
    int deleteUser(int uid);
}
