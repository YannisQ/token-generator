package com.personal.yzq.token.core;

import com.personal.yzq.token.model.GetTokenCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("systemTokenGenerator")
public class SystemTokenGenerator extends DefaultTokenGenerator {


    @Override
    protected boolean otherValidation(GetTokenCommand command) {
        return true;
    }

    @Override
    protected void afterCreateToken(GetTokenCommand command) {
        log.info("afterCreateToken:{}" + this.getClass());
    }
}
