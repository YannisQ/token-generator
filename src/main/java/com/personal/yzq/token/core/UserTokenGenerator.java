package com.personal.yzq.token.core;

import com.personal.yzq.token.model.GetTokenCommand;
import com.personal.yzq.token.model.TokenWrapper;

public class UserTokenGenerator extends DefaultTokenGenerator {


    @Override
    protected boolean otherValidation(GetTokenCommand command) {
        return false;
    }

    @Override
    protected TokenWrapper createToken(GetTokenCommand command) {
        return null;
    }
}
