package com.example.studyVue.web.controller;

import com.example.studyVue.web.service.ZuanService;
import com.example.studyVue.web.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类名称 ZuanController
 * @类描述 &lt;pre&gt;&lt;/pre&gt;
 * @作者 xwx yangw@innosail.cn
 * @创建时间 2020-07-15 10:00
 * @版本 1.00
 */
@RestController
@RequestMapping("z_a")
public class ZuanController {

    @Autowired
    private ZuanService zuanService;

    /**
     * 获取祖安列表
     */
    @GetMapping("/list")
    public ResultInfo getList(int page, int size) {
        return ResultInfo.success(zuanService.getList(page, size));
    }

    /**
     * 新增祖安语句
     */
    @GetMapping("/insert")
    public ResultInfo insert(String content) {
        zuanService.insert(content);
        return ResultInfo.success();
    }

    /**
     * 点赞
     */
    @GetMapping("/upvote")
    public ResultInfo upvote(int id) {
        zuanService.upvote(id);
        return ResultInfo.success();
    }
}
