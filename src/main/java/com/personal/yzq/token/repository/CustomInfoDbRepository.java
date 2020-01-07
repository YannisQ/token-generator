package com.personal.yzq.token.repository;

import com.personal.yzq.token.model.CustomWrapper;
import com.personal.yzq.token.model.entity.CustomDo;
import com.personal.yzq.token.model.entity.CustomTenantDo;
import com.personal.yzq.token.model.entity.CustomTokenTypeDo;
import com.personal.yzq.token.repository.mapper.CustomInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CustomInfoDbRepository implements CustomInfoRepository {

    @Autowired
    private CustomInfoMapper customInfoMapper;

    private Map<String, CustomWrapper> customCache = new ConcurrentHashMap<>();

    @Override
    public CustomWrapper getCustom(String systemId) {
        CustomWrapper customWrapper = customCache.get(systemId);
        if (null == customWrapper) {
            CustomDo customDo = customInfoMapper.getCustomDo(systemId);
            List<CustomTokenTypeDo> customTokenTypeDoList = customInfoMapper.getCustomTokenTypeDo(systemId);
            List<CustomTenantDo> customTenantDoList = customInfoMapper.getCustomTenantDo(systemId);
            customWrapper = new CustomWrapper(customDo, customTokenTypeDoList, customTenantDoList);
            customCache.put(systemId, customWrapper);
        }
        return customWrapper;
    }

}
