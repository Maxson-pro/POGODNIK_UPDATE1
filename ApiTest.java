package com.example.weatherapp;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

 class ApiTest {
    @Test
    void testFetchData() {
        Api api = new Api();
        String endpoint = "https://jsonplaceholder.typicode.com/posts/1";
        try {
            String result = api.fetchData(endpoint);
            assertNotNull(result, "Результат не должен быть null");
            assertTrue(result.contains("\"id\": 1"), "Результат тото тото ");

        }catch (IOException e) {
            fail("Исключение при выполнении FetchData: " + e.getMessage());
        }

    }
}
