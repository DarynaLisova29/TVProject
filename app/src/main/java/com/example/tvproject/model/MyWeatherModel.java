package com.example.tvproject.model;

import com.example.tvproject.SimpleCity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyWeatherModel {
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Integer message;
    @SerializedName("list")
    @Expose
    private List<ListWeather> list;



//    @SerializedName("city")
//    @Expose
//    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public List<ListWeather> getList() {
        return list;
    }

    public void setList(List<ListWeather> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MyWeatherModel{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", list=" + list +
                '}';
    }
}
