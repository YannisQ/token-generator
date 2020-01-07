package com.personal.yzq.token.repository.mapper;

import com.personal.yzq.token.model.entity.TokenDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenMapper {

    TokenDo getTokenDo(TokenDo tokenParam);
}
