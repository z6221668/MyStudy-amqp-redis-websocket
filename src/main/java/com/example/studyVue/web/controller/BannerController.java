package com.example.studyVue.web.controller;

import com.example.studyVue.web.service.BannerService;
import com.example.studyVue.web.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: z6~
 * @time: 2019-10-22 15:44
 */
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/get_banner_img")
    public ResultInfo getBannerImg() {
        return ResultInfo.success(bannerService.getBannerList());
    }
}
