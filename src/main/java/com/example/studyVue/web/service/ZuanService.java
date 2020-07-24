package com.example.studyVue.web.service;

import com.github.pagehelper.PageInfo;

public interface ZuanService {

    /**
     * 获取列表
     */
    PageInfo getList(int page, int size);

    /**
     * 新增
     */
    void insert(String content);

    /**
     * 点赞
     */
    void upvote(int id);
}
