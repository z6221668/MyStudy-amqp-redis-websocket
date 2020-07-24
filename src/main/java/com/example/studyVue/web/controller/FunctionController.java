package com.example.studyVue.web.controller;

import com.example.studyVue.web.service.FunctionService;
import com.example.studyVue.web.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: z6~
 * @time: 2019-12-11 16:25
 */
@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService;


    @GetMapping("/phone")
    public ResultInfo getPhoneAddress(String phone) {
        return ResultInfo.success(functionService.getPhoneAddress(phone));
    }
}
