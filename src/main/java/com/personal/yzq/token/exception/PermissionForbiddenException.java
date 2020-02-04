package com.personal.yzq.token.exception;

public class PermissionForbiddenException extends RuntimeException {

    public PermissionForbiddenException() {
        super();
    }

    public PermissionForbiddenException(String s) {
        super(s);
    }
}
