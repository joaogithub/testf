package com.fixeads.pager.network.listener;

import com.fixeads.pager.network.model.ErrorCode;

/**
 * Created by João Amaro on 09/11/2015.
 */
public interface RequestObjectListener<T> {

    void onSuccess(T response);

    void onError(ErrorCode errorCode, String message);
}
