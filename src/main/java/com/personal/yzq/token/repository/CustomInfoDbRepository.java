package com.personal.yzq.token.repository;

import com.personal.yzq.token.model.entity.Custom;
import com.personal.yzq.token.repository.mapper.CustomInfoMapper;

public class CustomInfoDbRepository implements CustomInfoRepository {

    private CustomInfoMapper customInfoMapper;

    @Override
    public Custom getCustom(String systemId, String systemSecret) {
        return customInfoMapper.getCustom(systemId, systemSecret);
    }
}
