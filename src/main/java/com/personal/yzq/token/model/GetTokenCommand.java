package com.personal.yzq.token.model;

import com.google.common.collect.Lists;
import com.personal.yzq.token.exception.AdaptedIllegalArgumentException;
import com.personal.yzq.token.model.entity.TokenDo;
import com.personal.yzq.token.repository.CustomInfoRepository;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class GetTokenCommand {

    private final TokenReqInfo tokenReqInfo;

    private final CustomWrapper customWrapper;

    @Setter
    private TokenWrapper dbToken;

    public GetTokenCommand(TokenReqInfo reqInfo, CustomInfoRepository customInfoRepository) {
        this.tokenReqInfo = reqInfo;
        this.customWrapper = customInfoRepository.getCustom(reqInfo.getSystemId());
        setExtensionParam();
    }

    private void setExtensionParam() {
        String authOrgCode = tokenReqInfo.getAuthOrgCode();
        if (StringUtils.isNotEmpty(authOrgCode)) {
            tokenReqInfo.setOrgId(authOrgCode);
        }
    }

    public void customValidation() {
        if (null == customWrapper.getCustomDo()) {
            throw new AdaptedIllegalArgumentException("没有对应的系统信息");
        }
        if (StringUtils.equalsIgnoreCase(customWrapper.getCustomDo().getIsValid(), "n")) {
            throw new AdaptedIllegalArgumentException("系统注册信息已失效");
        }
        if (!StringUtils.equals(customWrapper.getCustomDo().getSystemSecret(), tokenReqInfo.getSystemSecret())) {
            throw new AdaptedIllegalArgumentException("系统密码错误");
        }
    }

    public TokenDo prepareTokenParams() {
        TokenDo token = new TokenDo();
        token.setSystemId(tokenReqInfo.getSystemId());
        token.setUserId(tokenReqInfo.getUserId());
        token.setGrantType(tokenReqInfo.getGrantType());
        return token;
    }

    public boolean isDbTokenExistAndValid() {
        return dbToken.isValid();
    }

    public boolean isSingleLogin() {
        boolean singleFlag = StringUtils.isNotEmpty(customWrapper.getCustomDo().getSingleLoginGrantType()) &&
                StringUtils.containsIgnoreCase(customWrapper.getCustomDo().getSingleLoginGrantType(), tokenReqInfo.getGrantType());
        return singleFlag;
    }

    public boolean isTokenTypeExistsAndValid(String tokenTypeToCheck) {
        List<String> tokenTypesToCheck = Lists.newArrayList(tokenTypeToCheck);
        return isTokenTypesExistsAndValid(tokenTypesToCheck);
    }

    public boolean isTokenTypesExistsAndValid(List<String> tokenTypesToCheck) {
        return customWrapper.isTokenTypesExistsAndValid(tokenReqInfo.getGrantType(), tokenTypesToCheck);
    }

    public Date getTokenTypeValidDate(String tokenType) {
        return customWrapper.getTokenTypeValidDate(tokenReqInfo.getGrantType(), tokenType);
    }

    public String joinFieldsValue() {
        StringBuilder tokenValueBuilder = new StringBuilder();
        tokenValueBuilder.append("{\"systemId\":\"").append(tokenReqInfo.getSystemId());// todo 补充其他值
        return tokenValueBuilder.toString();
    }

    public TokenWrapper getDbTokenWrapper() {
        if (null == dbToken) {
            dbToken = new TokenWrapper(new TokenDo());
        }
        return dbToken;
    }
}
