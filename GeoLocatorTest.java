package com.example.weatherapp;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GeoLocatorTest {

    @Test
    public void testGetCity() throws Exception {
        Api mockApi = mock(Api.class);
        String mockResponse = new JSONObject()
                .put("city", "Moscow")
                .toString();
        when(mockApi.fetchData(anyString())).thenReturn(mockResponse);
        GeoLocator geoLocator = new GeoLocator();
        String city = geoLocator.getCity(mockApi);
        assertEquals("Moscow", city);
        verify(mockApi).fetchData("http://ip-api.com/json/");
    }
}