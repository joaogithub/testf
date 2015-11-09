package com.fixeads.pager.network.model;

import android.util.Log;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by João Amaro Silva on 09/11/2015.
 */
public abstract class CallbackList<T> implements Callback<List<T>> {

    private static final String TAG = "CallBackList";

    public abstract void onSuccess(List<T> list);

    public abstract void onError(ErrorCode errorCode, String message);

    @Override
    public void success(List<T> tResponseList, Response response) {

        if (tResponseList == null){
            Log.e(TAG, "tResponseList is null ");
            onError(ErrorCode.AN_ERROR_OCCURRED, ErrorCode.AN_ERROR_OCCURRED.getMessage());
            return;
        }

        if (tResponseList == null || (tResponseList!=null && tResponseList.isEmpty())) {
            onError(ErrorCode.ADS_NOTFOUND, "List is empty");
        } else {
            onSuccess(tResponseList);
        }
    }

    @Override
    public void failure(RetrofitError error) {

        if (error == null){
            Log.e(TAG, "ERROR is null ");
            onError(ErrorCode.AN_ERROR_OCCURRED, ErrorCode.AN_ERROR_OCCURRED.toString());
            return;
        }

        Log.e(TAG, "ERROR: " + error.getKind().name());

        if (error.getResponse() != null && error.getResponse().getStatus() == 403) {
            Log.e(TAG, "ERROR: " + error.getResponse().getStatus());
        } else {
            onError(null, error.getMessage());
        }
    }
}