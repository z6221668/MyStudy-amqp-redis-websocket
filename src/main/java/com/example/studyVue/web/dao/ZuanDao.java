package com.example.studyVue.web.dao;

import com.example.studyVue.web.entity.po.ZuanPO;

import java.util.List;

/**
 * 祖安dao
 */
public interface ZuanDao {

    List<ZuanPO> getList();

    void insert(ZuanPO zuanPO);

    void upvote(int id);
}
