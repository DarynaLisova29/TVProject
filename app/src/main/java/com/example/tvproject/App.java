package com.example.tvproject;

import android.app.Application;

import com.example.tvproject.api.WeatherApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private Retrofit retrofit;
    private static WeatherApi weatherApi;
    private static String URL="https://api.openweathermap.org/";
    public static String key = "fe3dea7f68cfa24794c7c5329fb08b55";


    @Override
    public void onCreate() {
        super.onCreate();
        retrofit=new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        weatherApi=retrofit.create(WeatherApi.class);

    }
    public static WeatherApi getWeather(){
        return weatherApi;
    }
}
