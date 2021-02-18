package com.jy.exception;


import org.springframework.security.core.AuthenticationException;

public class SysUserException extends AuthenticationException {
    public SysUserException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SysUserException(String msg) {
        super(msg);
    }
}
