package com.personal.yzq.token.resource;

import com.personal.yzq.token.model.GetTokenCommand;
import com.personal.yzq.token.model.ResultInfo;
import com.personal.yzq.token.model.TokenReqInfo;
import com.personal.yzq.token.model.entity.Token;
import com.personal.yzq.token.representation.TokenRepresentation;
import com.personal.yzq.token.service.TokenApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("token")
public class TokenResources {

    @Resource
    private TokenApplicationService tokenService;

    @RequestMapping(value = "getToken", method = RequestMethod.POST)
    public ResultInfo<TokenRepresentation> getToken(@RequestBody @Valid TokenReqInfo tokenReqInfo,
                                                    HttpServletResponse response) throws MethodArgumentNotValidException {
        GetTokenCommand getTokenCommand = new GetTokenCommand(tokenReqInfo);
        Token token = tokenService.getToken(getTokenCommand);
        addResponseHeadersIfNecessary(getTokenCommand, response);
        return token.convertToRepresentation();
    }

    private void addResponseHeadersIfNecessary(GetTokenCommand getTokenCommand, HttpServletResponse response) {
    }
}
