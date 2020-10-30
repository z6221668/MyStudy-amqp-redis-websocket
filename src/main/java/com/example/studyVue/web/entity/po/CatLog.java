package com.example.studyVue.web.entity.po;

import lombok.Data;

/**
 * @类名称 catLog
 * @类描述 &lt;pre&gt;&lt;/pre&gt;
 * @作者 xwx yangw@innosail.cn
 * @创建时间 2020-10-30 09:37
 * @版本 1.00
 */
@Data
public class CatLog {

    private int id;
    private int type;
    private String title;
    private String content;
    private int likeFlag;
    private int createTime;
}
