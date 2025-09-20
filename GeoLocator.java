package com.example.weatherapp;

import org.json.JSONObject;

public class GeoLocator {
    private final String IP_URL = "http://ip-api.com/json/";

    public String getCity(Api api) throws Exception {
        String res = api.fetchData(IP_URL);
        JSONObject data = new JSONObject(res);
        return data.getString("city");
    }
}
