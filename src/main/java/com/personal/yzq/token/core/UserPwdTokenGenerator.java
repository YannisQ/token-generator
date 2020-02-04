package com.personal.yzq.token.core;

import com.personal.yzq.token.model.GetTokenCommand;
import org.springframework.stereotype.Component;

@Component("userPwdTokenGenerator")
public class UserPwdTokenGenerator extends UserTokenGenerator{

    @Override
    protected void checkReqParams(GetTokenCommand command) {

    }

    @Override
    protected void checkUserIdentity(GetTokenCommand command) {

    }
}
