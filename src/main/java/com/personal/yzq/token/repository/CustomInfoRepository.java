package com.personal.yzq.token.repository;

import com.personal.yzq.token.model.CustomWrapper;

public interface CustomInfoRepository {

    CustomWrapper getCustom(String systemId);
}
