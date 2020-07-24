package com.example.studyVue.web.service.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.studyVue.web.exception.RException;
import com.example.studyVue.web.dao.UserDao;
import com.example.studyVue.web.entity.po.UserPO;
import com.example.studyVue.web.enums.ExceptionEnum;
import com.example.studyVue.web.service.UserService;
import com.example.studyVue.web.util.TokenUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: z6~
 * @time: 2019-10-16 09:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登录
     *
     * @param userPO
     */
    @Override
    public String loginByUp(UserPO userPO) {
        userPO.setPassword(SecureUtil.md5(userPO.getPassword()));
        System.out.println(SecureUtil.md5(userPO.getPassword()));
        UserPO login = userDao.loginByUp(userPO);
        if (!ObjectUtil.isNotEmpty(login)) {
            throw new RException(ExceptionEnum.USER_IS_NULL);
        }
        updateToken(login);
        String a = JSONObject.toJSONString(login);
        return TokenUtil.encrypt(a);
    }

    /**
     * 更新token
     */
    private void updateToken(UserPO userPO) {
        redisTemplate.opsForValue().set(userPO.getUserId(), userPO, 10, TimeUnit.HOURS);
    }

}
