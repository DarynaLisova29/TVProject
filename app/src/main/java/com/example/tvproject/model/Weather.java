package com.example.tvproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("main")
    @Expose
    private String main;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "main='" + main + '\'' +
                '}';
    }
}
