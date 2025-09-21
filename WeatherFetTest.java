package com.example.weatherapp;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

public class WeatherFetTest {
    @Mock
    private Api api;
    @InjectMocks
    private  WeatherFet weatherFet;
    @Test
    public void testFetchWeather() throws Exception {
        MockitoAnnotations.openMocks(this);
        String expRes = "Mocked response";
        when(api.fetchData("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Moscow?unitGroup=metric&key=MAMG44J4FXFPJTXZCL4GNVL3B&contentType=json&lang=ru"))
                .thenReturn(expRes);
        String result = weatherFet.fetchWeatherForCity("Moscow", api);
        assertEquals(expRes, result);
    }
}
