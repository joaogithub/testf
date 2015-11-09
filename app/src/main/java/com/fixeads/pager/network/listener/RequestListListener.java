package com.fixeads.pager.network.listener;

import com.fixeads.pager.network.model.ErrorCode;

import java.util.List;

/**
 * Created by João Amaro Silva on 08/11/2015.
 */
public interface RequestListListener<T> {

    void onSuccess(List<T> list);

    void onError(ErrorCode errorCode, String message);
}
