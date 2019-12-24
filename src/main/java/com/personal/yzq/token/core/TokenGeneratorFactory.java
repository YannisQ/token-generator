package com.personal.yzq.token.core;

import com.personal.yzq.token.model.TokenGeneratorEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TokenGeneratorFactory {

    @Autowired
    private Map<String, TokenGenerator> tokenGeneratorPool;

    public TokenGenerator createTokenGenerator(String grantType) {
        TokenGeneratorEnum generatorEnum = TokenGeneratorEnum.valueOf(StringUtils.upperCase(grantType));
        return tokenGeneratorPool.get(generatorEnum.getBeanName());
    }


//    public static void main(String[] args) {
//        TokenReqInfo reqInfo = new TokenReqInfo();
//        reqInfo.setGrantType("USER_PSSWORD");
//        DefaultTokenGenerator generator = createTokenGenerator(reqInfo);
//        generator.getCustomInfo();
//    }

}