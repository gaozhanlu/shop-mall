package com.gzl.common.result;

import lombok.Data;

@Data
public class MethodResult {
    
    private boolean status;
    private String message;

    protected MethodResult() {
    }

    protected MethodResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * 成功返回结果
     *
     * @param  message 提示信息
     */
    public static  MethodResult success(String message) {
        return new MethodResult(true, message);
    }

    /**
     * 失败返回结果
     * @param message  提示信息
     */
    public static  MethodResult failed(String message) {
        return new MethodResult(false,message);
    }
}
