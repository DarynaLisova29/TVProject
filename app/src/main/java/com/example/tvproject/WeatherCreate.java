package com.example.tvproject;

import static java.util.stream.Collectors.toList;

import com.example.tvproject.model.MyWeatherModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WeatherCreate {


//    public WeatherCreate(Observable<MyWeatherModel> observable) {
//        this.observable = observable;
//    }

    public static List<MyWeatherModel> getWeatherList(List<SimpleCity>city){
        List<MyWeatherModel>list=new ArrayList<>();
        List<SimpleCity>firstList=city.subList(0,city.size()/2);
        List<SimpleCity>secondList=city.subList(city.size()/2,city.size());
        Single<List<MyWeatherModel>> observable1=getObservable(firstList);

        Single<List<MyWeatherModel>> observable2= getObservable(secondList);

    //    Об'єднання результатів з обох Single об'єктів
        Single.zip(observable1,observable2,(weatherList1, weatherList2)->{
            List<MyWeatherModel>list1=new ArrayList<>();
            list1.addAll(weatherList1);
            list1.addAll(weatherList2);
            return list1;
        }).subscribeOn(Schedulers.io())
                .blockingSubscribe(list::addAll,Throwable::printStackTrace);

        return list;
    }

    public static Single<List<MyWeatherModel>>getObservable(List<SimpleCity>list){
        return Observable.fromIterable(list)
                .flatMap(cityEl->App.getWeather().getData(cityEl.getLat(),cityEl.getLon(),App.key))
                .subscribeOn(Schedulers.io())
                .toList();
    }
}
