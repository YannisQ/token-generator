package com.personal.yzq.token.model;

import com.personal.yzq.token.model.valobj.CustomTokenType;

import java.util.Hashtable;

public class CustomAuthority extends Hashtable<String,CustomTokenType> {


    public void addCustomTokenType(String grantType, CustomTokenType customTokenType) {
        this.put(grantType, customTokenType);
    }
}
