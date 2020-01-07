package com.personal.yzq.token.model.entity;

import lombok.Data;

@Data
public class CustomDo {

    private String systemId;

    private String systemName;

    private String systemSecret;

    private String isValid;

    private String authenticateType;

    private String singleLoginGrantType;

    private String businessField;

    private String papushAppId;

}
