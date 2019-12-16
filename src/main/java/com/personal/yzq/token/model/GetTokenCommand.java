package com.personal.yzq.token.model;

import com.personal.yzq.token.core.TokenGenerator;
import com.personal.yzq.token.core.TokenGeneratorFactory;
import com.personal.yzq.token.model.entity.Token;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

public class GetTokenCommand {

    private TokenGenerator tokenGenerator;

    public GetTokenCommand(TokenReqInfo reqInfo) {
        this.tokenGenerator = TokenGeneratorFactory.createTokenGenerator(reqInfo);
    }

    public Token execute() throws MethodArgumentNotValidException {
        return tokenGenerator.generate();
    }

    public List<Map<String, String>> getGeneratedResponseHeaders() {
        return tokenGenerator.getGeneratedResponseHeaders();
    }

}
