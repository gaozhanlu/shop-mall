package com.gzl.base.common.result;

public enum ResultCode implements ErrorCode {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    TIPS_ERROR(501,"参数错误"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    VALIDATE_FAILED(404, "服务器找不到请求的路径");


    private long code;
    private String message;

    private ResultCode(long code, String message) {
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
