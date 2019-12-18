package com.personal.yzq.token.core;

import com.personal.yzq.token.model.TokenReqInfo;
import com.personal.yzq.token.model.TokenWrapper;

public class UserTokenGenerator extends DefaultTokenGenerator {

    protected UserTokenGenerator(TokenReqInfo reqInfo) {
        super(reqInfo);
    }

    @Override
    protected boolean isPermitted(){
//        if (isValidParams()) {
//
//        }
        return false;
    }

    @Override
    protected TokenWrapper createToken() {
        return null;
    }
}
