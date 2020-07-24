package com.example.studyVue.web.service.impl;

import com.example.studyVue.web.dao.ZuanDao;
import com.example.studyVue.web.entity.po.ZuanPO;
import com.example.studyVue.web.service.ZuanService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @类名称 ZuanServiceImpl
 * @类描述 &lt;pre&gt;&lt;/pre&gt;
 * @作者 xwx yangw@innosail.cn
 * @创建时间 2020-07-15 10:01
 * @版本 1.00
 */
@Service
public class ZuanServiceImpl implements ZuanService {

    @Autowired
    private ZuanDao zuanDao;

    @Override
    public PageInfo getList(int page, int size) {
        PageHelper.startPage(page, size);
        List<ZuanPO> list = zuanDao.getList();
        return new PageInfo(list);
    }

    @Override
    public synchronized void insert(String content) {
        ZuanPO zuanPO = new ZuanPO();
        zuanPO.setContent(content);
        zuanPO.setPoint(0);
        zuanDao.insert(zuanPO);
    }

    @Override
    public synchronized void upvote(int id) {
        zuanDao.upvote(id);
    }
}
