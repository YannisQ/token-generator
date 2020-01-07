package com.personal.yzq.token.model.entity;

import lombok.Value;

@Value
public class CustomTenantDo {

    private String systemId;

    private String lesseeId;

    private String isValid;
}
