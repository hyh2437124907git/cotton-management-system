package com.common.exception;

/**
 * @author hyh
 * @date 2022/10/4 22:45
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
