package com.personal.yzq.token.representation;

public class ResultInfo<T> {

    private String code;

    private String message;

    private T data;

    public ResultInfo(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public static <T> ResultInfo<T> success(T data) {
        ResultInfo resultInfo = new ResultInfo(ResultCode.SUCCESS);
        resultInfo.data = data;
        return resultInfo;
    }
}
