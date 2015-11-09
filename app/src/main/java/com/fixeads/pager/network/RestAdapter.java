package com.fixeads.pager.network;

import com.fixeads.pager.utils.Constants;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.converter.GsonConverter;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class RestAdapter {

    public static retrofit.RestAdapter getGeneralAdapter() {
        return new retrofit.RestAdapter.Builder()
                .setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
                .setEndpoint(Constants.API_URL)
                .setConverter(new GsonConverter(new GsonBuilder().create()))
                .build();
    }

}
