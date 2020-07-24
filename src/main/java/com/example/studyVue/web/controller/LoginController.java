package com.example.studyVue.web.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.studyVue.web.entity.po.UserPO;
import com.example.studyVue.web.service.UserService;
import com.example.studyVue.web.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: z6~
 * @time: 2019-10-16 08:59
 */
@RequestMapping("/login")
@RestController

public class LoginController {

    //雪花算法
    private Snowflake snowflake = IdUtil.createSnowflake(0, 1);
    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @PostMapping("login_by_up")
    public ResultInfo loginByUserAndPwd(@RequestBody UserPO userPO) {
        return ResultInfo.success(userService.loginByUp(userPO));
    }

}
