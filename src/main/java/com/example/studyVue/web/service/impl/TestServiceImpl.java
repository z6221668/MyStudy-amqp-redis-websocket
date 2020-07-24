package com.example.studyVue.web.service.impl;

import com.example.studyVue.web.dao.TestDao;
import com.example.studyVue.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: z6~
 * @time: 2020-04-29 17:39
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestDao testDao;

    @Override
    public void insertName(String name) {
        testDao.insert(name);
    }
}
