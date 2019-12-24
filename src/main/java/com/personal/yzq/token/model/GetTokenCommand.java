package com.personal.yzq.token.model;

import com.personal.yzq.token.model.entity.Custom;
import com.personal.yzq.token.repository.CustomInfoRepository;
import org.apache.commons.lang3.StringUtils;

public class GetTokenCommand {

    private final TokenReqInfo tokenReqInfo;

    private final Custom custom;

    public GetTokenCommand(TokenReqInfo reqInfo, CustomInfoRepository customInfoRepository) {
        this.tokenReqInfo = reqInfo;
        this.custom = customInfoRepository.getCustom(reqInfo.getSystemId());
        setExtensionParam();
    }

    private void setExtensionParam() {
        String authOrgCode = tokenReqInfo.getAuthOrgCode();
        if (StringUtils.isNotEmpty(authOrgCode)) {
            tokenReqInfo.setOrgId(authOrgCode);
        }
    }

    public void customValidation() {
    }

}
