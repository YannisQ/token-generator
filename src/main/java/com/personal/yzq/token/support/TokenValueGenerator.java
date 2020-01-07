package com.personal.yzq.token.support;

import com.personal.yzq.token.model.GetTokenCommand;

public interface TokenValueGenerator {

    String getTokenValue(GetTokenCommand command);
}
