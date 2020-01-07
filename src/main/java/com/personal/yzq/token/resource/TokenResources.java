package com.personal.yzq.token.resource;

import com.personal.yzq.token.model.TokenReqInfo;
import com.personal.yzq.token.model.TokenWrapper;
import com.personal.yzq.token.model.entity.TokenDo;
import com.personal.yzq.token.representation.ResultInfo;
import com.personal.yzq.token.service.TokenApplicationService;
import lombok.extern.slf4j.Slf4j;
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
    public ResultInfo<TokenDo> getToken(@RequestBody @Valid TokenReqInfo tokenReqInfo,
                                        HttpServletResponse response) {
        TokenWrapper tokenWrapper = tokenService.getToken(tokenReqInfo);
        addResponseHeadersIfNecessary(tokenWrapper, response);
        return tokenWrapper.convertToRepresentation();// todo 数据库对象是否应直接暴露，没有值的属性不会返回
    }

    private void addResponseHeadersIfNecessary(TokenWrapper tokenWrapper, HttpServletResponse response) {
    }
}
