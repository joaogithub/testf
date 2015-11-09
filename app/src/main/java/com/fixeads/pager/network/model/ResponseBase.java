package com.fixeads.pager.network.model;

/**
 * Created by João on 09/11/2015.
 */
public class ResponseBase {

    private boolean status;
    private int code;
    private String message;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
}
