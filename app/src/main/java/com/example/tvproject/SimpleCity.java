package com.example.tvproject;

import android.text.Spanned;

import com.egeniq.androidtvprogramguide.entity.ProgramGuideChannel;

public class SimpleCity implements ProgramGuideChannel {
    private String id;
    private double lon;
    private double lat;
    private Spanned name;
    private String imageUrl;

    public SimpleCity(double lon, double lat, Spanned name, String imageUrl) {
        this.lon = lon;
        this.lat = lat;
        this.name = name;
        this.imageUrl = imageUrl;
        id=lon+":"+lat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Spanned getName() {
        return name;
    }

    public void setName(Spanned name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
