package com.fixeads.pager.network.model;

import android.util.Log;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Timwe on 24/09/2015.
 */
public abstract class CallbackObject<T> implements Callback<ResponseObject<T>> {

    private static final String TAG = "CallbackObject";

    public abstract void onSuccess(T object);

    public abstract void onError(ErrorCode errorCode, String message);

    @Override
    public void success(ResponseObject<T> tResponseObject, Response response) {

        if (tResponseObject == null){
            onError(ErrorCode.AN_ERROR_OCCURRED, ErrorCode.AN_ERROR_OCCURRED.getMessage());
            return;
        }

        if (!tResponseObject.getStatus()) {
            ErrorCode errorCode = ErrorCode.getValue(tResponseObject.getCode());
            onError(errorCode, errorCode.getMessage());
        } else {
            onSuccess(tResponseObject.getData());
        }

    }

    @Override
    public void failure(RetrofitError error) {

        if (error == null){
            onError(ErrorCode.AN_ERROR_OCCURRED, ErrorCode.AN_ERROR_OCCURRED.getMessage());
            return;
        }

        Log.w(TAG, "ERROR: " + error.getKind().name());

        if (error.getResponse() != null && error.getResponse().getStatus() == 403) {
            Log.w(TAG, "ERROR: " + error.getResponse().getStatus());
        } else {
            onError(null, error.getMessage()!=null?error.getMessage():"error");
        }
    }
}
