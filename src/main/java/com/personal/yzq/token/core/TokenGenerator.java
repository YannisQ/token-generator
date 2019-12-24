package com.personal.yzq.token.core;

import com.personal.yzq.token.model.GetTokenCommand;
import com.personal.yzq.token.model.TokenWrapper;

public interface TokenGenerator {

    TokenWrapper generate(GetTokenCommand command);

}
