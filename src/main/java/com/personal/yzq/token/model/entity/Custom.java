package com.personal.yzq.token.model.entity;

import com.personal.yzq.token.model.CustomAuthority;
import com.personal.yzq.token.model.valobj.CustomTenant;

import java.util.List;

public class Custom {

    private String systemId;

    private String systemName;

    private String systemSecret;

    private String isValid;

    private String authenticateType;

    private String singleLoginGrantType;

    private String businessField;

    private String papushAppId;

    private CustomAuthority customAuthority;

    private List<CustomTenant> customTenants;
}
