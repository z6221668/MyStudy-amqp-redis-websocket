package com.example.studyVue.web.enums;

public enum ExceptionEnum {
    //系统级错误
    UNKNOW_ERROR(-1, "未知错误"),
    RPC_ERROR(-2, "远程调用错误"),
    MYSQL_SQL_GRAMMAR_ERROR(-8, "sql语法错误"),
    DB_SPLIT_ERROR(-9, "系统表分割错误"),
    METHOD_ARGUMENT_TYPE_MISMATCH_ERROR(-10, "方法参数无法转换"),
    CAN_NOT_FIND_USER_FROM_REQ(-11, "未能从请求中获取到用户信息"),
    APOLLO_URL_NOT_SET(-12, "阿波罗地址未设置"),
    REMOTE_CALL_ERROR(-13, "远程调用错误"),
    OBJECT_NOT_EQUAL(-14, "对比对象不相等"),
    REQUEST_PARAM_NULL(-15, "请求参数缺失"),
    IP_UN_ALLOW(-16, "IP无权访问"),
    BUSY_SERVER(-17, "服务器繁忙，请稍后再试"),

    //常用错误
    ADD_FAIL(1, "新增失败"),
    LOSE_FILED(2, "缺少必须条件"),
    NAME_IS_NULL(3, "名称不能为空"),
    NAME_IS_REPETITION(3, "名称不能重复"),
    PARAM_NULL(4, "参数不能为空"),
    EDIT_FAIL(5, "编辑失败"),
    PARAM_ILLEGAL(6, "参数不合法"),

    //登录验证相关
    TOKEN_NULL(100, "身份验证不存在"),
    TOKEN_INVALID(101, "身份验证失效"),
    TOKEN_VERIFY_FAIL(102, "身份验证验证失败"),
    VERIFY_PARAM_INCOMPLETE(103, "身份验证参数不全"),
    VERIFY_USER_NOT_FOUND(104, "未找到验证用户信息"),
    DECRYPT_USER_INFO_ERROR(105, "解密用户信息失败"),
    TOKEN_EXPIRE(107, "登录状态过期，请重新登录"),
    ONLY_APP_LOGIN(108, "只允许客户端登录"),
    CAN_NOT_FOUND_BOUND_COMPANY_LIST(109, "未找到关联公司信息"),
    COMPANY_ID_IS_NULL(110, "公司ID不能为空"),

    //http请求相关
    HTTP_METHOD_NOT_SUPPORT(200, "不支持的请求方法类型"),
    HTTP_BODY_NOT_READABLE(201, "HTTP请求体无法读取"),
    HTTP_PARAMETER_ERROR(202, "HTTP请求参数无法对应"),
    IP_NOT_IN_SAFETY(203, "当前IP不在安全IP范围内，请联系主管！"),

    USER_IS_NULL(1001, "账号或密码错误，请重新输入");


    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
