package com.fixeads.pager.network.listener;

import com.squareup.okhttp.internal.spdy.ErrorCode;

import java.util.List;

/**
 * Created by João Amaro Silva on 08/11/2015.
 */
public interface RequestListListener<T> {

    void onSuccess(List<T> list);

    void onError(ErrorCode errorCode, String message);
}
