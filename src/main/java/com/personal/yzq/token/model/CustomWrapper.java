package com.personal.yzq.token.model;

import com.personal.yzq.token.model.entity.CustomDo;
import com.personal.yzq.token.model.entity.CustomTenantDo;
import com.personal.yzq.token.model.entity.CustomTokenTypeDo;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class CustomWrapper {

    private final CustomDo customDo;

    private final Map<String, List<CustomTokenTypeDo>> tokenTypeDoMap;

    private final List<CustomTenantDo> tenant;

    public CustomWrapper(CustomDo customDo, List<CustomTokenTypeDo> tokenTypeDoList, List<CustomTenantDo> tenantDos) {
        this.customDo = customDo;
        this.tenant = tenantDos;
        if (null == tokenTypeDoList) {
            tokenTypeDoMap = new HashMap<>();
        } else {
            tokenTypeDoMap = tokenTypeDoList.stream().collect(Collectors.toMap(CustomTokenTypeDo::getSystemId,
                    (c) -> {
                        List<CustomTokenTypeDo> customTokenTypeDoList = new ArrayList<>();
                        customTokenTypeDoList.add(c);
                        return customTokenTypeDoList;
                    }));
        }
    }

    public boolean isTokenTypesExistsAndValid(String grantType, List<String> tokenTypesToCheck) {
        if (null != tokenTypeDoMap) {
            List<CustomTokenTypeDo> customTokenTypeDoList = tokenTypeDoMap.get(grantType);
            if (null != customTokenTypeDoList) {
                long tokenTypeCount = 0;
                for (String tokenTypeToCheck : tokenTypesToCheck) {
                    tokenTypeCount += customTokenTypeDoList.stream().filter(customTokenTypeDo ->
                            tokenTypeToCheck.equals(customTokenTypeDo.getTokenType())
                    ).count();
                }
                return (tokenTypeCount > 0);
            }
        }
        return false;
    }

    public Date getTokenTypeValidDate(String grantType, String tokenType) {
        List<CustomTokenTypeDo> customTokenTypeDoList = tokenTypeDoMap.get(grantType);
        int validHours = customTokenTypeDoList.stream().filter(c ->
                tokenType.equals(c.getTokenType())
        ).findFirst().get().getTokenEffectiveTime();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, validHours);
        Date validDate = cal.getTime();
        return validDate;
    }

}
