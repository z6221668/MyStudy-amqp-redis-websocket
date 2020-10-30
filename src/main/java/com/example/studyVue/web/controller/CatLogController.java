package com.example.studyVue.web.controller;

import com.example.studyVue.web.service.CatLogService;
import com.example.studyVue.web.util.ResultInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类名称 CatLogController
 * @类描述 &lt;pre&gt;&lt;/pre&gt;
 * @作者 xwx yangw@innosail.cn
 * @创建时间 2020-10-30 09:40
 * @版本 1.00
 */
@RestController
@RequestMapping("/log")
public class CatLogController {

    @Autowired
    private CatLogService catLogService;

    @GetMapping("/list")
    public ResultInfo getList(int page, int limit) {
        PageInfo pageInfo=catLogService.getCatLogList(page, limit);
        return ResultInfo.success(pageInfo);
    }
}
