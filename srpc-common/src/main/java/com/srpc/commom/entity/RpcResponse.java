package com.srpc.commom.entity;

import com.srpc.commom.constant.ResponseCode;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author sunyuejun
 */
@Data
@ToString
public class RpcResponse<T> implements Serializable {
    private Integer statusCode;

    private String message;
    private T data;

    public static <T> RpcResponse<T> success(T data) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setMessage(ResponseCode.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    public <T> RpcResponse<T> fail(ResponseCode code) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }

}
