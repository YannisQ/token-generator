package com.personal.yzq.token.model.entity;

import com.personal.yzq.token.model.ResultInfo;
import com.personal.yzq.token.model.valobj.TokenInfo;
import com.personal.yzq.token.representation.TokenRepresentation;

public class Token {

    private TokenInfo accessToken;
    private TokenInfo refreshToken;
    private TokenInfo automaticToken;

    public ResultInfo<TokenRepresentation> convertToRepresentation() {
        return null;
    }

}
