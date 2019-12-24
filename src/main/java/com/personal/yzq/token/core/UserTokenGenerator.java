package com.personal.yzq.token.core;

import com.personal.yzq.token.model.TokenWrapper;

public class UserTokenGenerator extends DefaultTokenGenerator {


    @Override
    protected boolean otherValidation() {
        return false;
    }

    @Override
    protected TokenWrapper createToken() {
        return null;
    }
}
