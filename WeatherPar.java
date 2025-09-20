package com.example.weatherapp;


import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherPar {
    public String parWeatherData(String rawJson) {
        JSONObject object = new JSONObject(rawJson);
        JSONArray days = object.optJSONArray("days");
        if (days != null && days.length() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.min(days.length(), 7); i++) {
                JSONObject day = days.getJSONObject(i);

                String dateTime = day.getString("datetime");
                double temperature = day.getDouble("temp");
                String conditions = day.getString("conditions");

                sb.append(dateTime).append(": ")
                        .append((int) temperature).append("°C, ")
                        .append(conditions).append("\n");
            }
            return sb.toString();
        }
        return "Нет такого бебебе.";
    }
}
