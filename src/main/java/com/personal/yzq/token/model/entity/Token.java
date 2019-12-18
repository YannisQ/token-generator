package com.personal.yzq.token.model.entity;

import com.personal.yzq.token.model.valobj.TokenInfo;
import lombok.Value;

@Value
public class Token {

    private String id;
    private String systemId;
    private String userId;
    private String grantType;

    private TokenInfo accessToken;
    private TokenInfo refreshToken;
    private TokenInfo automaticToken;

}
