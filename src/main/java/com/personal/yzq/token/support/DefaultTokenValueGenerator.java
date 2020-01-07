package com.personal.yzq.token.support;

import com.personal.yzq.token.model.GetTokenCommand;
import org.springframework.stereotype.Component;

@Component
public class DefaultTokenValueGenerator implements TokenValueGenerator {

    @Override
    public String getTokenValue(GetTokenCommand command) {
        String tokenValue = "";
        try {
            tokenValue = command.joinFieldsValue();// todo 待补充加密算法
        } catch (Exception e) {

        }
        return tokenValue;
    }
}
