package com.personal.yzq.token.repository.mapper;

import com.personal.yzq.token.model.entity.CustomDo;
import com.personal.yzq.token.model.entity.CustomTenantDo;
import com.personal.yzq.token.model.entity.CustomTokenTypeDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomInfoMapper {

    CustomDo getCustomDo(@Param("systemId") String systemId);

    List<CustomTokenTypeDo> getCustomTokenTypeDo(@Param("systemId") String systemId);

    List<CustomTenantDo> getCustomTenantDo(@Param("systemId") String systemId);
}
