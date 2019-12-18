package com.personal.yzq.token.model;

import com.personal.yzq.token.core.*;

import java.util.function.Function;

public enum TokenGeneratorEnum {

    USER_PASSWORD(UserPwdTokenGenerator::new),
    SYSTEM_PASSWORD(SystemTokenGenerator::new),
    AUTOMATIC(AutomaticTokenGenerator::new),
    SSO_COOKIE(SsoTokenGenerator::new),
    CLIENT(SystemTokenGenerator::new);

    private final Function<TokenReqInfo,DefaultTokenGenerator> constructor;

    TokenGeneratorEnum(Function<TokenReqInfo,DefaultTokenGenerator> constructor) {
        this.constructor = constructor;
    }

    public Function<TokenReqInfo,DefaultTokenGenerator> getConstructor() {
        return constructor;
    }

}
