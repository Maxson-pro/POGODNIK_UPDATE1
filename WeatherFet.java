package com.example.weatherapp;

public class WeatherFet {
    private final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    private final String API_KEY = "MAMG44J4FXFPJTXZCL4GNVL3B";

    public String fetchWeatherForCity(String city, Api api) throws Exception {
        String URL = BASE_URL + city + "?unitGroup=metric&key=" + API_KEY + "&contentType=json&lang=ru";
        return api.fetchData(URL);
    }
}
