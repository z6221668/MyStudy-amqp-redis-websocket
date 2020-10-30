package com.example.studyVue.web.service;

import com.example.studyVue.web.entity.po.CatLog;
import com.github.pagehelper.PageInfo;

public interface CatLogService {
    PageInfo<CatLog> getCatLogList(int page, int limit);
}
