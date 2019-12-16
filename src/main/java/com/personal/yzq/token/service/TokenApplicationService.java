package com.personal.yzq.token.service;

import com.personal.yzq.token.model.GetTokenCommand;
import com.personal.yzq.token.model.entity.Token;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class TokenApplicationService {

    public Token getToken(GetTokenCommand command) throws MethodArgumentNotValidException {
        return command.execute();
    }
}
