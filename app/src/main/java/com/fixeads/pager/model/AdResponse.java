package com.fixeads.pager.model;

import java.util.List;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class AdResponse {

    private int page;

    private String next_page_url;

    private List<Ad> ads;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }
}
