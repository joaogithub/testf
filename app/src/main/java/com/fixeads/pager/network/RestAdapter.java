package com.fixeads.pager.network;

import android.content.Context;

import com.fixeads.pager.utils.Constants;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class RestAdapter {

    public static retrofit.RestAdapter getGeneralAdapter(Context ctx) {

        File httpCacheDirectory = new File(ctx.getCacheDir(), "responses");

        Cache cache = null;

        cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);

        OkHttpClient okHttpClient = new OkHttpClient();
        if (cache != null) {
            okHttpClient.setCache(cache);
        }

        return new retrofit.RestAdapter.Builder()
                .setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
                .setEndpoint(Constants.API_URL)
                .setClient(new OkClient(okHttpClient))
                .setConverter(new GsonConverter(new GsonBuilder().create()))
                .build();
    }

}
