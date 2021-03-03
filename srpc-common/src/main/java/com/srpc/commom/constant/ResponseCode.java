package com.srpc.commom.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sunyuejun
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {
    //
    SUCCESS(200, "调用成功"),
    FAIL(500, "调用失败"),
    NOT_FOUND_METHOD(500, "未找到指定方法"),
    NOT_FOUND_CLASS(500, "未找到指定类");

    /**
     * http状态码
     */
    private final int code;
    /**
     * 错误消息
     */
    private final String message;
}
