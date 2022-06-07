package com.gzl.common.result;

import lombok.Data;

@Data
public class ViewResult<T> {
    private long code;
    private String message;
    private T data;

    protected ViewResult() {
    }

    protected ViewResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ViewResult<T> success(T data) {
        return new ViewResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ViewResult<T> success(T data, String message) {
        return new ViewResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ViewResult<T> failed(ErrorCode errorCode) {
        return new ViewResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }


    /**
     * 失败返回结果
     * @param
     */
    public static <T> ViewResult<T> failed( long code ,String message) {
        return new ViewResult<T>(code, message, null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> ViewResult<T> failed(ErrorCode errorCode,String message) {
        return new ViewResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> ViewResult<T> failed(String message) {
        return new ViewResult<T>(ResultCode.TIPS_ERROR.getCode(), message, null);
    }

    /**
     * 失败返回结果 此处暂时故意保留500的错误 用来区分这就是服务器崩了。。。
     */
    public static <T> ViewResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ViewResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> ViewResult<T> validateFailed(String message) {
        return new ViewResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ViewResult<T> unauthorized(T data) {
        return new ViewResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ViewResult<T> forbidden(T data) {
        return new ViewResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}
