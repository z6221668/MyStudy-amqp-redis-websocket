package com.example.studyVue.intercepter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.studyVue.web.exception.RException;
import com.example.studyVue.web.entity.po.UserPO;
import com.example.studyVue.web.enums.ExceptionEnum;
import com.example.studyVue.web.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author: z6~
 * @time: 2019-10-16 09:41
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StrUtil.isEmpty(token)) {
            token = request.getParameter("token");
        }

        return checkToken(token,request);
    }

    private boolean checkToken(String token, HttpServletRequest httpServletRequest) {
        if (StrUtil.isEmpty(token)) {
            throw new RException(ExceptionEnum.VERIFY_PARAM_INCOMPLETE);
        }
        UserPO userPO;
        try {
            String upo = TokenUtil.decrypt(token);
            userPO = JSONObject.parseObject(upo, UserPO.class);
        } catch (Exception e) {
            throw new RException(ExceptionEnum.DECRYPT_USER_INFO_ERROR);
        }
        checkTokenUserInfo(userPO);
        httpServletRequest.setAttribute("login_staff", userPO);
        return true;
    }

    /**
     * 校验TOKEN
     */
    private void checkTokenUserInfo(UserPO userPO) {
        if (ObjectUtil.isEmpty(userPO)) {
            throw new RException(ExceptionEnum.VERIFY_USER_NOT_FOUND);
        }
        if (userPO.getId() == 0) {
            throw new RException(ExceptionEnum.VERIFY_USER_NOT_FOUND);
        }
        Object redisValue = redisTemplate.opsForValue().get(userPO.getUserId());
        if (redisValue == null) {
            throw new RException(ExceptionEnum.TOKEN_EXPIRE);
        } else {
            redisTemplate.opsForValue().set(userPO.getUserId(), redisValue, 10, TimeUnit.HOURS);
        }
    }


}
