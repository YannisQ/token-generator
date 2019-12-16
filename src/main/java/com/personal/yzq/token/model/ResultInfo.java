package com.personal.yzq.token.model;

import lombok.Value;

@Value
public class ResultInfo<T> {

    private String code;

    private String message;

    private T data;
}
