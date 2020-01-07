package com.personal.yzq.token.model.entity;

import lombok.Value;

@Value
public class CustomTokenTypeDo {

    private String systemId;

    private String grantType;

    private String tokenType;

    private Integer tokenEffectiveTime;

    private String tokenRefreshSwitch;

}
