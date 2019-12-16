package com.personal.yzq.token.model.valobj;

import lombok.Value;

@Value
public class CustomTokenType {

    private String tokenType;

    private Integer tokenEffectiveTime;

    private String tokenRefreshSwitch;

}
