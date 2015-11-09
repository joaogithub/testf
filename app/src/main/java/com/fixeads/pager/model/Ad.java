package com.fixeads.pager.model;

import java.io.Serializable;

/**
 * Created by João Amaro Silva on 08-11-2015.
 */
public class Ad implements Serializable {

    private int id;
    private String title;
    private String description;
    private String url;
    private String created;
    private int category_id;
    private String list_label;
    private double map_lon;
    private double map_lat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String category;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public double getMap_lon() {
        return map_lon;
    }

    public void setMap_lon(double map_lon) {
        this.map_lon = map_lon;
    }

    public double getMap_lat() {
        return map_lat;
    }

    public void setMap_lat(double map_lat) {
        this.map_lat = map_lat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getList_label() {
        return list_label;
    }
}
