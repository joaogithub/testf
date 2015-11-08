package com.fixeads.pager.network;

import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.converter.GsonConverter;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class RestAdapter {

    public static retrofit.RestAdapter getGeneralAdapter() {
        return new retrofit.RestAdapter.Builder()
                .setLogLevel(retrofit.RestAdapter.LogLevel.BASIC)
                .setEndpoint(com.fixeads.pager.utils.Constants.API_URL)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
                    }
                })
                .setConverter(
                        new GsonConverter(
                                new GsonBuilder()
                                        .create()))
                .build();
    }

}
