package com.personal.yzq.token.core;

import com.personal.yzq.token.model.TokenWrapper;
import org.springframework.stereotype.Component;

@Component("systemTokenGenerator")
public class SystemTokenGenerator extends DefaultTokenGenerator {


    @Override
    protected boolean otherValidation() {
        return false;
    }

    @Override
    protected TokenWrapper createToken() {
        return null;
    }
}
