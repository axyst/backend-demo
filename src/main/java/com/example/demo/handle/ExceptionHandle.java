package com.example.demo.handle;

import com.example.demo.domain.Result;
import com.example.demo.exception.HelloException;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof HelloException) {
            HelloException helloException = (HelloException) e;
            return ResultUtil.error(helloException.getCode(), helloException.getMessage());
        } else {
            logger.error("system error {}", e);
            return ResultUtil.error(-1, "unknown error");
        }
    }
}
