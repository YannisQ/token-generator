package com.personal.yzq.token.repository;

import com.personal.yzq.token.repository.mapper.BlackAndWhiteListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlackAndWhiteListRepository {

    @Autowired
    private BlackAndWhiteListMapper blackAndWhiteListMapper;

    public String getUserIdFromBlackList(String userId, String businessFiled, String lesseeId) {
        return blackAndWhiteListMapper.getUserIdFromBlackList(userId, businessFiled, lesseeId);
    }

    public String getUserIdFromWhiteList(String userId, String businessFiled, String lesseeId) {
        return blackAndWhiteListMapper.getUserIdFromWhiteList(userId, businessFiled, lesseeId);
    }
}
