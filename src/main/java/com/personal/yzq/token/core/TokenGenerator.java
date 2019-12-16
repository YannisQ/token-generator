package com.personal.yzq.token.core;

import com.google.common.collect.Lists;
import com.personal.yzq.token.model.TokenReqInfo;
import com.personal.yzq.token.model.entity.Custom;
import com.personal.yzq.token.model.entity.Token;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

@Getter
public abstract class TokenGenerator {

    protected TokenGenerator(TokenReqInfo tokenReqInfo) {
        setExtensionParam(tokenReqInfo);
        this.tokenReqInfo = tokenReqInfo;
    }

    private final TokenReqInfo tokenReqInfo;

    @Setter
    private Custom customInfo;

    private List<Map<String, String>> generatedResponseHeaders = Lists.newArrayList();

    protected abstract boolean isPermitted() throws MethodArgumentNotValidException;

    protected abstract Token createToken();

    protected void afterCreateToken() {
    }

    public Token generate() throws MethodArgumentNotValidException {
        if (this.isPermitted()) {
            Token token = this.createToken();
            this.afterCreateToken();
            return token;
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
