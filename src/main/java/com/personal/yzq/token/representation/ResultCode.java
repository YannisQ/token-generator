package com.personal.yzq.token.representation;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS("000000", "成功");

    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
