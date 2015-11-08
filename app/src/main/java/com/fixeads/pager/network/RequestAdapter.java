package com.fixeads.pager.network;

import com.fixeads.pager.model.Ad;
import com.fixeads.pager.network.model.CallbackList;
import com.squareup.okhttp.internal.spdy.ErrorCode;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class RequestAdapter {

    public static void getAd(final int id, final com.fixeads.pager.network.listener.RequestObjectListener<com.fixeads.pager.model.Ad> requestObjectListener) {
        getAdRequest(id, requestObjectListener);
    }

    public static void getAllAds(final int page, final int quantity, final com.fixeads.pager.network.listener.RequestListListener<com.fixeads.pager.model.Ad> requestListListener){
        getAllAdsRequest(page, quantity, requestListListener);
    }

    public static com.fixeads.pager.network.interfaces.IGeneral getIGeneral(){
        return com.fixeads.pager.network.RestAdapter.getGeneralAdapter().create(com.fixeads.pager.network.interfaces.IGeneral.class);
    }

    private static void getAllAdsRequest(final int page, final int quantity, final com.fixeads.pager.network.listener.RequestListListener<com.fixeads.pager.model.Ad> requestListListener) {
        getIGeneral().getAllAds(page, quantity, new CallbackList<Ad>() {
            @Override
            public void onSuccess(List<com.fixeads.pager.model.Ad> list) {
                requestListListener.onSuccess(list);
            }

            @Override
            public void onError(ErrorCode errorCode, String message) {
                requestListListener.onError(errorCode, message);
            }
        });
    }

    private static void getAdRequest(final int id, final com.fixeads.pager.network.listener.RequestObjectListener<com.fixeads.pager.model.Ad> requestObjectListener) {
        getIGeneral().getAd(id, new Callback<com.fixeads.pager.model.Ad>() {
            @Override
            public void success(com.fixeads.pager.model.Ad ad, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }

        });
    }

}
