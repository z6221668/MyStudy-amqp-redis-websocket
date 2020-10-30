package com.example.studyVue.web.service.impl;

import com.example.studyVue.web.dao.CatLogDao;
import com.example.studyVue.web.entity.po.CatLog;
import com.example.studyVue.web.service.CatLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @类名称 CatLogServiceImpl
 * @类描述 &lt;pre&gt;&lt;/pre&gt;
 * @作者 xwx yangw@innosail.cn
 * @创建时间 2020-10-30 09:37
 * @版本 1.00
 */
@Service
public class CatLogServiceImpl implements CatLogService {

    @Autowired
    CatLogDao catLogDao;

    @Override
    public PageInfo<CatLog> getCatLogList(int page, int limit) {
        PageHelper.startPage(page, limit);
        return new PageInfo<>(catLogDao.getLogList());

    }
}
