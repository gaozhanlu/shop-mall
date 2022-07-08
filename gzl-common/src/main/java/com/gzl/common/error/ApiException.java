package com.gzl.common.error;

import com.gzl.common.result.ErrorCode;
import com.gzl.common.result.ResultCode;

public class ApiException extends RuntimeException{
    private ErrorCode errorCode;


    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = ResultCode.TIPS_ERROR;
    }

    public ApiException(String message) {
        super(message);
    }


    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
