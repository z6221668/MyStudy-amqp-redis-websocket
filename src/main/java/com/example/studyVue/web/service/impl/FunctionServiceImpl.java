package com.example.studyVue.web.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONString;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.studyVue.web.exception.RException;
import com.example.studyVue.web.service.FunctionService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: z6~
 * @time: 2019-12-11 16:27
 */
@Service
public class FunctionServiceImpl implements FunctionService {

    private final String phoneUrl = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=";

    @Override
    public String getPhoneAddress(String phone) {
        try {
            String response = HttpUtil.get(phoneUrl + phone);
            int len = response.indexOf("=");
            String str = response.substring(len+1,response.length()).trim();
            Map<String, Object> data = JSONObject.parseObject(str);
            return data.get("carrier").toString()==null?"未知":data.get("carrier").toString();
        }catch (Exception e){
            throw new RException("请输入正确的手机号");
        }

    }
}
