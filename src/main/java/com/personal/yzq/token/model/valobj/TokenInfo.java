package com.personal.yzq.token.model.valobj;

import lombok.Value;

import java.util.Date;

@Value
public class TokenInfo {

    private String tokenValue;

    private Date tokenEffectiveDate;
}
