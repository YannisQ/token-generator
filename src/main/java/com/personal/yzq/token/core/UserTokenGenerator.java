package com.personal.yzq.token.core;

import com.personal.yzq.token.model.TokenReqInfo;
import com.personal.yzq.token.model.entity.Token;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class UserTokenGenerator extends TokenGenerator {

    protected UserTokenGenerator(TokenReqInfo reqInfo) {
        super(reqInfo);
    }

    @Override
    protected boolean isPermitted() throws MethodArgumentNotValidException {
//        if (isValidParams()) {
//
//        }
        return false;
    }

    @Override
    protected Token createToken() {
        return null;
    }
}
