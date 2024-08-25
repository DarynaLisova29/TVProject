package com.example.tvproject.api;



import com.example.tvproject.model.MyWeatherModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.rxjava3.core.Observable;

public interface WeatherApi {
    @GET("data/2.5/forecast")
    Observable<MyWeatherModel> getData(@Query("lat") double lat, @Query("lon") double lon,
                                       @Query("appid") String key );
}
