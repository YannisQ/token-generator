package com.personal.yzq.token.core;

import com.personal.yzq.token.model.GetTokenCommand;
import com.personal.yzq.token.model.TokenWrapper;
import lombok.Getter;

@Getter
public abstract class DefaultTokenGenerator implements TokenGenerator {

    protected abstract boolean otherValidation();

    protected abstract TokenWrapper createToken();

    protected void afterCreateToken() {
    }

    @Override
    public TokenWrapper generate(GetTokenCommand command) {
        if (this.isPermitted(command)) {
            TokenWrapper tokenWrapper = this.createToken();
            this.afterCreateToken();
            return tokenWrapper;
        }
        return null;
    }

    protected boolean isPermitted(GetTokenCommand command) {
        command.customValidation();
        return this.otherValidation();
    }



}
