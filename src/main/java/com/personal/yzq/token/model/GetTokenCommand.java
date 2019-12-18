package com.personal.yzq.token.model;

import com.personal.yzq.token.core.TokenGenerator;
import com.personal.yzq.token.core.TokenGeneratorFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class GetTokenCommand {

    private TokenGenerator tokenGenerator;

    public GetTokenCommand(TokenReqInfo reqInfo) {
        this.tokenGenerator = TokenGeneratorFactory.createTokenGenerator(reqInfo);
    }

    public TokenWrapper execute() throws MethodArgumentNotValidException {
        return tokenGenerator.generate();
    }

}
