package com.personal.yzq.token.repository;

import com.personal.yzq.token.model.entity.Custom;
import com.personal.yzq.token.repository.mapper.CustomInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CustomInfoDbRepository implements CustomInfoRepository {

    @Autowired
    private CustomInfoMapper customInfoMapper;

    private Map<String, Custom> customCache = new ConcurrentHashMap<>();

    @Override
    public Custom getCustom(String systemId) {
        Custom custom = customCache.get(systemId);
        if (null == custom) {
            custom = customInfoMapper.getCustom(systemId);
            customCache.put(systemId, custom);
        }
        return custom;
    }

}
