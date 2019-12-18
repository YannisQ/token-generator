package com.personal.yzq.token.core;

import com.personal.yzq.token.model.TokenReqInfo;
import com.personal.yzq.token.model.TokenWrapper;
import com.personal.yzq.token.model.entity.Custom;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
public abstract class DefaultTokenGenerator implements TokenGenerator {

    protected DefaultTokenGenerator(TokenReqInfo tokenReqInfo) {
        setExtensionParam(tokenReqInfo);
        this.tokenReqInfo = tokenReqInfo;
    }

    private final TokenReqInfo tokenReqInfo;

    @Setter
    private Custom customInfo;

    protected abstract boolean isPermitted();

    protected abstract TokenWrapper createToken();

    protected void afterCreateToken() {
    }

    @Override
    public TokenWrapper generate() {
        if (this.isPermitted()) {
            TokenWrapper tokenWrapper = this.createToken();
            this.afterCreateToken();
            return tokenWrapper;
        }
        return null;
    }


    private void setExtensionParam(TokenReqInfo tokenReqInfo) {
        String authOrgCode = tokenReqInfo.getAuthOrgCode();
        if (StringUtils.isNotEmpty(authOrgCode)) {
            tokenReqInfo.setOrgId(authOrgCode);
        }
    }
}
