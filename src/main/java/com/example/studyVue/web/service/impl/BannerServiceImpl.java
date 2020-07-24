package com.example.studyVue.web.service.impl;

import com.example.studyVue.web.dao.BannerDao;
import com.example.studyVue.web.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: z6~
 * @time: 2019-10-22 15:50
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public List<String> getBannerList() {
        return bannerDao.getBannerImg();
    }
}
