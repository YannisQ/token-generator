package com.personal.yzq.token.representation;

import lombok.Value;

import java.util.Date;

@Value
public class TokenRepresentation {

    private String accessToken;

    private Date accessTokenValid;

    private String refreshToken;

    private Date refreshTokenValid;

    private String automaticToken;

    private Date automaticTokenValid;
}
