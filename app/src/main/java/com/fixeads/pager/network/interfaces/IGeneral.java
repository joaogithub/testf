package com.fixeads.pager.network.interfaces;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by João Amaro Silva on 09/11/2015.
 */
public interface IGeneral {

    /******
     * NEWS REQUESTS
     ******/
    @GET("")
    void getAd(@Query("i") int id, Callback<com.fixeads.pager.model.Ad> cb);

    @GET("")
    void getAllAds(@Query("p") int page, @Query("q") int quantity, com.fixeads.pager.network.model.CallbackList<com.fixeads.pager.model.Ad> cb);

}
