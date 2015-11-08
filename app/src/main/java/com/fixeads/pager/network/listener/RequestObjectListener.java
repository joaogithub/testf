package com.fixeads.pager.network.listener;

/**
 * Created by João Amaro on 09/11/2015.
 */
public interface RequestObjectListener<T> {

    void onSuccess(T response);

    void onError(int errorCode, String message);
}
