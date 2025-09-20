package com.example.weatherapp;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SiteSelectionSystem selector = new SiteSelectionSystem(scanner);
        Api apiFetcher = new Api();
        GeoLocator geoLocator = new GeoLocator();
        WeatherFet weatherFetcher = new WeatherFet();
        WeatherPar parser = new WeatherPar();
        WeatherSen sender = new WeatherSen();

        int option = selector.selectOption();
        switch(option) {
            case 1:
                String city = geoLocator.getCity(apiFetcher);
                String rawWeatherData = weatherFetcher.fetchWeatherForCity(city, apiFetcher);
                String parsedWeather = parser.parWeatherData(rawWeatherData);
                String message = "Погода в " + city + ":\n" + parsedWeather;
                sender.sendWeather(message);
                break;

            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Ошибка попробуйте снова гыгыгыгыгы");
        }
    }
}
