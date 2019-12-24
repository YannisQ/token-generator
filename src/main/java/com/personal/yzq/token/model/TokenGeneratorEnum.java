package com.personal.yzq.token.model;

public enum TokenGeneratorEnum {

    USER_PASSWORD("userPwdTokenGenerator"),
    SYSTEM_PASSWORD("systemPwdTokenGenerator"),
    AUTOMATIC("automaticTokenGenerator"),
    SSO_COOKIE("ssoTokenGenerator"),
    CLIENT("systemTokenGenerator");

    private final String beanName;

    TokenGeneratorEnum(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
