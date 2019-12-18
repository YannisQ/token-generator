package com.personal.yzq.token.representation;

import lombok.Value;

@Value
public class ResultInfo<T> {

    private String code;

    private String message;

    private T data;
}
