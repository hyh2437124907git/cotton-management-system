package com.hyh.config;

import com.common.exception.ServiceException;
import com.common.rest.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hyh
 * @date 2022/4/7 17:25
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ServiceException.class)
    public R<?> onException(Exception e) {
        log.error(e.getMessage(),e);
        return R.runtimeFail(e.getMessage());
    }

}
