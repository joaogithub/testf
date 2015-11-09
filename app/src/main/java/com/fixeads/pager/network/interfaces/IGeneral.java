package com.fixeads.pager.network.interfaces;


import com.fixeads.pager.model.Ad;
import com.fixeads.pager.model.AdResponse;
import com.fixeads.pager.network.model.CallbackList;
import com.fixeads.pager.network.model.CallbackObject;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by João Amaro Silva on 09/11/2015.
 */
public interface IGeneral {

    /******
     * ADS REQUESTS
     ******/
    @GET("/")
    void getAd(@Query("i") int id, Callback<Ad> cb);

    @GET("/")
    void getAllAds(CallbackObject<AdResponse> cb);

}
