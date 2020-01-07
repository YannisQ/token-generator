package com.personal.yzq.token.model;

import com.google.common.collect.Lists;
import com.personal.yzq.token.model.entity.TokenDo;
import com.personal.yzq.token.representation.ResultInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TokenWrapper {

    public TokenWrapper(TokenDo tokenDo) {
        this.tokenDo = tokenDo;
    }

    @Getter
    private TokenDo tokenDo;

    @Getter
    @Setter
    private List<Map<String, String>> generatedResponseHeaders = Lists.newArrayList();

    public ResultInfo<TokenDo> convertToRepresentation() {
        return ResultInfo.success(tokenDo);
    }

    public boolean isValid() {
        try {
            return null != tokenDo && tokenDo.getAccessTokenValid().after(new Date());
        } catch (NullPointerException e) {
            return false;
        }
    }

    public TokenWrapper setAccessToken(String tokenValue, Date tokenValidDate) {
        tokenDo.setAccessToken(tokenValue);
        tokenDo.setAccessTokenValid(tokenValidDate);
        return this;
    }

    public TokenWrapper setRefreshToken(String tokenValue, Date tokenValidDate) {
        tokenDo.setRefreshToken(tokenValue);
        tokenDo.setRefreshTokenValid(tokenValidDate);
        return this;
    }

}
