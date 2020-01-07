package com.personal.yzq.token.repository;

import com.personal.yzq.token.model.TokenWrapper;
import com.personal.yzq.token.model.entity.TokenDo;

public interface TokenRepository {

    void save(TokenDo token);

    TokenWrapper getTokenInfo(TokenDo token);

}
