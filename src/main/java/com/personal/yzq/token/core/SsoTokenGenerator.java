package com.personal.yzq.token.core;

import com.personal.yzq.token.model.GetTokenCommand;
import org.springframework.stereotype.Component;

@Component("ssoTokenGenerator")
public class SsoTokenGenerator extends UserTokenGenerator {


    @Override
    protected boolean otherValidation(GetTokenCommand command) {
        return false;
    }

    @Override
    protected void checkReqParams(GetTokenCommand command) {

    }

    @Override
    protected void checkUserIdentity(GetTokenCommand command) {

    }
}
