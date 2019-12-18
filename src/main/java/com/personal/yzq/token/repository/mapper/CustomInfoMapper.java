package com.personal.yzq.token.repository.mapper;

import com.personal.yzq.token.model.entity.Custom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomInfoMapper {

    Custom getCustom(@Param("systemId") String systemId, @Param("systemSecret") String systemSecret);
}
