package com.personal.yzq.token.core;

import com.personal.yzq.token.model.GetTokenCommand;
import org.springframework.stereotype.Component;

@Component("systemPwdTokenGenerator")
public class SystemPwdTokenGenerator extends UserTokenGenerator {

    @Override
    protected void checkReqParams(GetTokenCommand command) {

    }

    @Override
    protected void checkUserIdentity(GetTokenCommand command) {

    }
}
