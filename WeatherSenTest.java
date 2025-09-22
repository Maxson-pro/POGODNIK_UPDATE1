package com.example.weatherapp;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.verify;

public class WeatherSenTest {
    @InjectMocks
    private WeatherSen weatherSen;

    @Test
    public void testSendWeather() {
        MockitoAnnotations.openMocks(this);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String message = "Тест";
        weatherSen.sendWeather(message);
        String expOut = message + "\n";
        String actOut = outputStream.toString();
        assert expOut.equals(actOut);
    }
}