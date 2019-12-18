package com.personal.yzq.token.repository;

import com.personal.yzq.token.model.entity.Token;
import com.personal.yzq.token.model.valobj.TokenInfo;

public interface TokenRepository {

    void update(Token token);

    TokenInfo getTokenInfo(Token token);

}
