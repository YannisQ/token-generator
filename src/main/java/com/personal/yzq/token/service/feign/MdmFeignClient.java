package com.personal.yzq.token.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "MDM-SERVICE")
public interface MdmFeignClient {

    @RequestMapping(value = "/xx/xx", method = RequestMethod.GET)
    Map getLesseeIdInfo(@RequestParam("uniqueDeptid") String uniqueDeptid);
}
