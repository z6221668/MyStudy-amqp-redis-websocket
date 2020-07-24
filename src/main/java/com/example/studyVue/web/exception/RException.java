package com.example.studyVue.web.exception;

import com.example.studyVue.web.enums.ExceptionEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: z6~
 * @time: 2019-10-16 09:21
 */
@Data
public class RException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;
    private Object data;

    public RException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.msg = exceptionEnum.getMsg();
        this.code = exceptionEnum.getCode();
    }

    public RException(ExceptionEnum exceptionEnum, Object data) {
        super(exceptionEnum.getMsg());
        this.msg = exceptionEnum.getMsg();
        this.code = exceptionEnum.getCode();
        this.data = data;
    }

    public RException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RException(String msg) {
        super();
        this.msg = msg;
    }

    public RException() {
        super();
    }
}
