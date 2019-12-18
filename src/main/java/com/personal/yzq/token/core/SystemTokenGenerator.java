package com.personal.yzq.token.core;

import com.personal.yzq.token.model.TokenReqInfo;
import com.personal.yzq.token.model.TokenWrapper;

public class SystemTokenGenerator extends DefaultTokenGenerator {

    public SystemTokenGenerator(TokenReqInfo reqInfo) {
        super(reqInfo);
    }

    @Override
    protected boolean isPermitted() {

        return false;
    }

    @Override
    protected TokenWrapper createToken() {
        return null;
    }
}
