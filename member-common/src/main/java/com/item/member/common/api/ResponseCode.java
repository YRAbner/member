package com.item.member.common.api;

/**
 * @author: yr
 * @desc: 响应码实现
 * @date: 2022/4/13 12:55
 */
public enum ResponseCode implements IResponseCode{
    SUCCESS(200 , "交易成功"),
    FAILED(500 , "交易失败");

    private long code;
    private String message;

    ResponseCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
