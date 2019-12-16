package com.personal.yzq.token.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TokenReqInfo {

    /**
     * 分配的系统ID
     */
    @NotNull(message = "参数systemId不能为空")
    private String systemId;

    /**
     * 分配的系统密钥
     */
    @NotNull(message = "参数systemSecret不能为空")
    private String systemSecret;

    /**
     * 授权类型
     */
    @NotNull(message = "参数grantType不能为空")
    private String grantType;

    /**
     * 用户UM号
     */
    private String userId;

    /**
     * 用户账号密码
     */
    private String userPassword;

    /**
     * 分配的组织机构ID
     */
    private String orgId;

    /**
     * via orgId
     */
    private String authOrgCode;

    /**
     * 自动登录token
     */
    private String automaticToken;

    /**
     * 客户端IP
     */
    private String sourceIp;

    /**
     * 图形验证码对应唯一ID
     */
    private String randomCodeId;

    /**
     * 用户输入的图形验证码
     */
    private String validateNum;

    /**
     * PASESSION值
     */
    private String paSession;

    /**
     * CAS_SSO_COOKIE值
     */
    private String casSsoCookie;

    /**
     * 最后一次登录的设备ID
     */
    private String machineInfo;

    /**
     * 最后一次登录的设备类型
     */
    private String machineType;

    /**
     * 滑块登录 初始化esg接口 register.php的返回值
     */
    private String challenge;

    /**
     * 滑块登录 验证结果唯一值
     */
    private String seccode;

    /**
     * 滑块登录 滑块参数校验字符串
     */
    private String validate;

    /**
     * 滑块登录 滑块接入方私钥
     */
    private String geetestkey;

    /**
     * 验证码类型，slider-滑块
     */
    private String vertifyMode = "";
}
