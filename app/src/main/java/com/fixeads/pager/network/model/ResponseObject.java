package com.fixeads.pager.network.model;

/**
 * Created by Timwe on 23/09/2015.
 */
public class ResponseObject<T> extends ResponseBase{

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
