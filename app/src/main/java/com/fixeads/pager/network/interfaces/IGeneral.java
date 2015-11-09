package com.fixeads.pager.network.interfaces;


import com.fixeads.pager.model.Ad;
import com.fixeads.pager.model.AdResponse;

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

    @GET("/?json=1&search[category_id]=25")
    void getAllAds(Callback<AdResponse> adResponse);

}
