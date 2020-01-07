package com.personal.yzq.token.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenDo {


    private String id;
    private String systemId;
    private String userId;
    private String grantType;

    private String accessToken;
    private Date accessTokenValid;

    private String refreshToken;
    private Date refreshTokenValid;

    private String automaticToken;
    private Date automaticTokenValid;

}
