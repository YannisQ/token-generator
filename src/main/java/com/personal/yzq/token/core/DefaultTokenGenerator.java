package com.personal.yzq.token.core;

import com.google.common.collect.Lists;
import com.personal.yzq.token.exception.IllegalConfigurationException;
import com.personal.yzq.token.model.GetTokenCommand;
import com.personal.yzq.token.model.TokenWrapper;
import com.personal.yzq.token.repository.TokenRepository;
import com.personal.yzq.token.support.TokenValueGenerator;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
public abstract class DefaultTokenGenerator implements TokenGenerator {

    private final static String TYPE_ACCESS_TOKEN = "accessToken";
    private final static String TYPE_REFRESH_TOKEN = "refreshToken";

    @Autowired
    protected TokenRepository tokenRepository;

    @Autowired
    protected TokenValueGenerator tokenValueGenerator;

    protected abstract boolean otherValidation(GetTokenCommand command);

    //protected abstract TokenWrapper createToken(GetTokenCommand command);

    protected void afterCreateToken(GetTokenCommand command) {
    }

    @Override
    public TokenWrapper generate(GetTokenCommand command) {
        if (this.isPermitted(command)) {
            TokenWrapper tokenWrapper = this.createToken(command);// todo 加锁 or else，防止重复生成
            this.afterCreateToken(command);
            return tokenWrapper;
        }
        return null;
    }

    protected boolean isPermitted(GetTokenCommand command) {
        command.customValidation();
        return this.otherValidation(command);
    }

    protected TokenWrapper createToken(GetTokenCommand command) {
        TokenWrapper dbToken = tokenRepository.getTokenInfo(command.prepareTokenParams());
        if (dbToken.isValid() && !command.isSingleLogin()) {
            return dbToken;
        } else {
            command.setDbToken(dbToken);
            return this.generateTokenByConfig(command);
        }
    }

    protected TokenWrapper generateTokenByConfig(GetTokenCommand command) {
        if (isTokenTypeExistsAndValid(command)) {
            return generateAccessAndRefreshToken(command);
        }
        throw new IllegalConfigurationException("校验失败：该系统没有对应token类型信息");
    }

    protected boolean isTokenTypeExistsAndValid(GetTokenCommand command) {
        List<String> tokenTypes = Lists.newArrayList(TYPE_ACCESS_TOKEN, TYPE_REFRESH_TOKEN);
        return command.isTokenTypesExistsAndValid(tokenTypes);
    }

    protected TokenWrapper generateAccessAndRefreshToken(GetTokenCommand command) {
        TokenWrapper dbToken = command.getDbTokenWrapper();
        dbToken.setAccessToken(tokenValueGenerator.getTokenValue(command), command.getTokenTypeValidDate(TYPE_ACCESS_TOKEN)).
                setRefreshToken(tokenValueGenerator.getTokenValue(command), command.getTokenTypeValidDate(TYPE_REFRESH_TOKEN));
        tokenRepository.save(dbToken.getTokenDo());
        return dbToken;
    }

}
