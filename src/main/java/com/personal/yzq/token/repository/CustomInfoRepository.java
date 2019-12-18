package com.personal.yzq.token.repository;

import com.personal.yzq.token.model.entity.Custom;

public interface CustomInfoRepository {

    Custom getCustom(String systemId, String systemSecret);
}
