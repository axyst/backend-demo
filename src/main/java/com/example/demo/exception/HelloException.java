package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

public class HelloException extends RuntimeException {

    private Integer code;

    public HelloException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
