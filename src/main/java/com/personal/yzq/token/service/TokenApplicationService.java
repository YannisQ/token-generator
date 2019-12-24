package com.personal.yzq.token.service;

import com.personal.yzq.token.core.TokenGenerator;
import com.personal.yzq.token.core.TokenGeneratorFactory;
import com.personal.yzq.token.model.GetTokenCommand;
import com.personal.yzq.token.model.TokenReqInfo;
import com.personal.yzq.token.model.TokenWrapper;
import com.personal.yzq.token.repository.CustomInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenApplicationService {

    @Autowired
    private TokenGeneratorFactory tokenGeneratorFactory;

    @Autowired
    private CustomInfoRepository customInfoRepository;

    public TokenWrapper getToken(TokenReqInfo reqInfo) {
        GetTokenCommand getTokenCommand = new GetTokenCommand(reqInfo, customInfoRepository);
        TokenGenerator tokenGenerator = tokenGeneratorFactory.createTokenGenerator(reqInfo.getGrantType());
        return tokenGenerator.generate(getTokenCommand);
    }
}
