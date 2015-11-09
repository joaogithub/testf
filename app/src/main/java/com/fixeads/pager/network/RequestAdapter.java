package com.fixeads.pager.network;

import android.content.Context;

import com.fixeads.pager.model.AdResponse;
import com.fixeads.pager.network.interfaces.IGeneral;
import com.fixeads.pager.network.listener.RequestObjectListener;
import com.fixeads.pager.network.model.ErrorCode;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class RequestAdapter {

    public static void getAllAds(Context ctx, final RequestObjectListener<AdResponse> requestObjectListener){
        getAllAdsRequest(ctx, requestObjectListener);
    }

    public static IGeneral getIGeneral(Context ctx){
        return RestAdapter.getGeneralAdapter(ctx).create(com.fixeads.pager.network.interfaces.IGeneral.class);
    }

    private static void getAllAdsRequest(Context ctx, final RequestObjectListener<AdResponse> requestObjectListener) {
        getIGeneral(ctx).getAllAds(new Callback<AdResponse>() {
            @Override
            public void success(AdResponse adResponse, Response response) {
                requestObjectListener.onSuccess(adResponse);
            }

            @Override
            public void failure(RetrofitError error) {

                if (error.getResponse() != null && error.getResponse().getStatus() == 403) {
                    requestObjectListener.onError(ErrorCode.AN_ERROR_OCCURRED, ErrorCode.AN_ERROR_OCCURRED.getMessage());
                }
                else if(error.getKind() != null && error.getKind() == RetrofitError.Kind.NETWORK){
                    requestObjectListener.onError(ErrorCode.ERROR_CONNECTION, ErrorCode.ERROR_CONNECTION.getMessage());
                }
                else {
                    requestObjectListener.onError(ErrorCode.AN_ERROR_OCCURRED, ErrorCode.AN_ERROR_OCCURRED.getMessage());
                }
            }
        });
    }

}
