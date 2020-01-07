package com.personal.yzq.token.repository;

import com.personal.yzq.token.model.TokenWrapper;
import com.personal.yzq.token.model.entity.TokenDo;
import com.personal.yzq.token.repository.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenDbRepository implements TokenRepository {

    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public void save(TokenDo token) {

    }

    @Override
    public TokenWrapper getTokenInfo(TokenDo tokenParam) {
        TokenDo tokenDo = tokenMapper.getTokenDo(tokenParam);
        return new TokenWrapper(tokenDo);
    }

}
