package com.fixeads.pager.network.model;

/**
 * Created by João Amaro Silva on 08/11/2015.
 */
public enum ErrorCode {

    AN_ERROR_OCCURRED(0, "An error has occurred"),
    ERROR_CONNECTION(1, "Connection error. Please check your connection."),
    MISSING_PARAMS(104, "Missing parameters"),
    ADS_NOTFOUND(109, "Ad not found"),
    INVALID_QUERY(113, "Invalid query type"),
    QUERY_TOOSMALL(114, "Query too small");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        setCode(code);
        setMessage(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ErrorCode getValue(int code){
        ErrorCode[] values = ErrorCode.values();
        for (ErrorCode value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return ErrorCode.AN_ERROR_OCCURRED;
    }
}
