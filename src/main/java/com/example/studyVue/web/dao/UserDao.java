package com.example.studyVue.web.dao;

import com.example.studyVue.web.entity.po.UserPO;

import java.util.List;

public interface UserDao {

    /**
     * 通过用户名和密码查找用户
     */
    UserPO loginByUp(UserPO userPO);

    /**
     * 获取所有
     */
    List<UserPO> selectAll();
}
