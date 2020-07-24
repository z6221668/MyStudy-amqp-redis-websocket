package com.example.studyVue.web.entity.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: z6~
 * @time: 2019-10-16 09:06
 */
@Getter
@Setter

public class UserPO {

    private int id;
    private String phone;
    private String password;
    private String nickName;
    private String userId;
    private int createTime;
}
