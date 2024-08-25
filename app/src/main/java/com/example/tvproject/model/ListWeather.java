package com.example.tvproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

public class ListWeather {
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather;
    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    @Override
    public String toString() {
        return "ListWeather{" +
                "main=" + main +
                ", weather=" + weather +
                ", dtTxt='" + dtTxt + '\'' +
                '}';
    }
//    public String getTime(){
//        return dtTxt.substring(dtTxt.indexOf(' '),dtTxt.length()-2);
//    }
public ZonedDateTime getTime() {
    // Вирізання часу з рядка
    String timeString = dtTxt.substring(dtTxt.indexOf(' ') + 1, dtTxt.length()).trim();

    // Форматер для парсингу часу
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Парсинг часу
    LocalTime localTime = LocalTime.parse(timeString, timeFormatter);

    // Використання поточної дати
    LocalDate currentDate = LocalDate.now();

    // Об'єднання дати і часу в LocalDateTime і перетворення в ZonedDateTime з вказанням часової зони
    ZoneId zoneId = ZoneId.of("UTC"); // або будь-яка інша часова зона
    ZonedDateTime zonedDateTime = currentDate.atTime(localTime).atZone(zoneId);

    return zonedDateTime;
}
}
