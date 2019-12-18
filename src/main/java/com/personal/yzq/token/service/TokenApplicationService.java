package com.personal.yzq.token.service;

import com.personal.yzq.token.model.GetTokenCommand;
import com.personal.yzq.token.model.TokenWrapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class TokenApplicationService {

    public TokenWrapper getToken(GetTokenCommand command) throws MethodArgumentNotValidException {
        return command.execute();
    }
}
