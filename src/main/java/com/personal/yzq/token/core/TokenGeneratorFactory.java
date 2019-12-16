package com.personal.yzq.token.core;

import com.personal.yzq.token.model.TokenGeneratorEnum;
import com.personal.yzq.token.model.TokenReqInfo;
import org.apache.commons.lang3.StringUtils;

public class TokenGeneratorFactory {

    public static TokenGenerator createTokenGenerator(TokenReqInfo reqInfo) {
        TokenGeneratorEnum generatorEnum = TokenGeneratorEnum.valueOf(StringUtils.upperCase(reqInfo.getGrantType()));
        return generatorEnum.getConstructor().apply(reqInfo);
    }

    public static void main(String[] args) {
        TokenReqInfo reqInfo = new TokenReqInfo();
        reqInfo.setGrantType("USER_PSSWORD");
        TokenGenerator generator = createTokenGenerator(reqInfo);
        generator.getCustomInfo();
    }

}