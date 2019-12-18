package com.personal.yzq.token.model;

import com.google.common.collect.Lists;
import com.personal.yzq.token.model.entity.Token;
import com.personal.yzq.token.representation.ResultInfo;
import com.personal.yzq.token.representation.TokenRepresentation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public class TokenWrapper {

    private Token token;

    @Getter
    @Setter
    private List<Map<String, String>> generatedResponseHeaders = Lists.newArrayList();

    public ResultInfo<TokenRepresentation> convertToRepresentation() {
        return null;
    }
}
