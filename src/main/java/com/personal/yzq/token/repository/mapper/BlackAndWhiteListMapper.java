package com.personal.yzq.token.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlackAndWhiteListMapper {


    String getUserIdFromBlackList(@Param("userId") String userId, @Param("businessFiled") String businessFiled, @Param("lesseeId") String lesseeId);

    String getUserIdFromWhiteList(@Param("userId") String userId, @Param("businessFiled") String businessFiled, @Param("lesseeId") String lesseeId);
}
