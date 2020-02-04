package com.personal.yzq.token.core;

import com.personal.yzq.token.exception.AdaptedIllegalArgumentException;
import com.personal.yzq.token.exception.PermissionForbiddenException;
import com.personal.yzq.token.model.GetTokenCommand;
import com.personal.yzq.token.model.TokenWrapper;
import com.personal.yzq.token.repository.BlackAndWhiteListRepository;
import com.personal.yzq.token.service.LesseeInfoService;
import com.personal.yzq.token.service.feign.MdmFeignClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public abstract class UserTokenGenerator extends DefaultTokenGenerator {

    @Autowired
    private BlackAndWhiteListService blackAndWhiteListService;

    @Autowired
    private MdmFeignClient mdmFeignClient;

    @Override
    protected boolean otherValidation(GetTokenCommand command) {
        this.checkReqParams(command);
        this.checkLesseeAndUser(command);
        this.checkUserIfLimited(command);
        this.checkUserIdentity(command);
        return false;
    }

    protected abstract void checkReqParams(GetTokenCommand command);

    protected void checkLesseeAndUser(GetTokenCommand command) {
        // 获取租户
        String lesseeId = ((LesseeInfoService) orgId -> {
            Map rMap = mdmFeignClient.getLesseeIdInfo(orgId);
            if (null == rMap || null == rMap.get("data")) {
                throw new AdaptedIllegalArgumentException(orgId + "组织机构不存在！");
            }
            return (String) rMap.get("data");
        }).getLesseeIdByOrgId(command.getOrgId());
        // 校验租户有效性
        List<String> configuredLesseeList = command.getConfiguredValidLesseeId();
        boolean isLesseeValid = false;
        if (null != configuredLesseeList) {
            isLesseeValid = configuredLesseeList.stream().anyMatch(configuredLess -> StringUtils.equalsIgnoreCase(configuredLess, lesseeId));
        }
        if (!isLesseeValid) {
            throw new AdaptedIllegalArgumentException("租户信息不存在或者注册信息已失效");
        }
        command.setLesseeId(lesseeId);
        // 校验用户有效性

    }

    protected void checkUserIfLimited(GetTokenCommand command) {
        boolean isLimited = (!blackAndWhiteListService.isUserInWhiteList(command)
                && blackAndWhiteListService.isUserInBlackList(command));
        if (isLimited) {
            throw new PermissionForbiddenException("您已被列入黑名单！系统拒绝登录！");
        }
    }

    protected abstract void checkUserIdentity(GetTokenCommand command);

    @Override
    protected TokenWrapper createToken(GetTokenCommand command) {
        return null;
    }

    @Service
    public static class BlackAndWhiteListService {

        @Autowired
        private BlackAndWhiteListRepository blackAndWhiteListRepository;

        public boolean isUserInBlackList(GetTokenCommand command) {
            String userId = blackAndWhiteListRepository.getUserIdFromBlackList(command.getUserId(), command.getBusinessFiled(), command.getLesseeId());
            return StringUtils.isNotEmpty(userId);
        }

        public boolean isUserInWhiteList(GetTokenCommand command) {
            String userId = blackAndWhiteListRepository.getUserIdFromWhiteList(command.getUserId(), command.getBusinessFiled(), command.getLesseeId());
            return StringUtils.isNotEmpty(userId);
        }
    }
}
