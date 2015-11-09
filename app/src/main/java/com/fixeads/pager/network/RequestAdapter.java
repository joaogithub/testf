package com.fixeads.pager.network;

import com.fixeads.pager.model.Ad;
import com.fixeads.pager.model.AdResponse;
import com.fixeads.pager.network.listener.RequestObjectListener;
import com.fixeads.pager.network.model.CallbackObject;
import com.fixeads.pager.network.model.ErrorCode;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class RequestAdapter {

    public static void getAd(final int id, final com.fixeads.pager.network.listener.RequestObjectListener<Ad> requestObjectListener) {
        getAdRequest(id, requestObjectListener);
    }

    public static void getAllAds(final int page, final int quantity, final RequestObjectListener<AdResponse> requestObjectListener){
        getAllAdsRequest(requestObjectListener);
    }

    public static com.fixeads.pager.network.interfaces.IGeneral getIGeneral(){
        return com.fixeads.pager.network.RestAdapter.getGeneralAdapter().create(com.fixeads.pager.network.interfaces.IGeneral.class);
    }

    private static void getAllAdsRequest(final RequestObjectListener<AdResponse> requestObjectListener) {
        getIGeneral().getAllAds(new CallbackObject<AdResponse>() {
            @Override
            public void onSuccess(AdResponse response) {
                requestObjectListener.onSuccess(response);
            }

            @Override
            public void onError(ErrorCode errorCode, String message) {
                requestObjectListener.onError(errorCode, message);
            }
        });
    }

    private static void getAdRequest(final int id, final RequestObjectListener<Ad> requestObjectListener) {
        getIGeneral().getAd(id, new Callback<Ad>() {
            @Override
            public void success(Ad ad, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }

        });
    }

}
