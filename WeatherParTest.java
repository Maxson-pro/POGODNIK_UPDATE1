package com.example.weatherapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeatherParTest {

    @Test
    public void testParWeatherData_validJson() {
        WeatherPar weatherPar = new WeatherPar();
        String json = """
                {
                    "city": "Moscow",
                    "days": [
                        {
                            "datetime": "2025-09-19",
                            "temp": 12.0,
                            "conditions": "Дождь, Частично облачно"
                        },
                        {
                            "datetime": "2025-09-20",
                            "temp": 13.0,
                            "conditions": "Дождь, Пасмурная погода"
                        },
                        {
                            "datetime": "2025-09-21",
                            "temp": 16.0,
                            "conditions": "Пасмурная погода"
                        },
                        {
                            "datetime": "2025-09-22",
                            "temp": 19.0,
                            "conditions": "Частично облачно"
                        },
                        {
                            "datetime": "2025-09-23",
                            "temp": 18.0,
                            "conditions": "Дождь, Частично облачно"
                        },
                        {
                            "datetime": "2025-09-24",
                            "temp": 12.0,
                            "conditions": "Дождь, Пасмурная погода"
                        },
                        {
                            "datetime": "2025-09-25",
                            "temp": 7.0,
                            "conditions": "Частично облачно"
                        }
                    ]
                }
                """;

        String expected = """
                2025-09-19: 12°C, Дождь, Частично облачно
                2025-09-20: 13°C, Дождь, Пасмурная погода
                2025-09-21: 16°C, Пасмурная погода
                2025-09-22: 19°C, Частично облачно
                2025-09-23: 18°C, Дождь, Частично облачно
                2025-09-24: 12°C, Дождь, Пасмурная погода
                2025-09-25: 7°C, Частично облачно
                """;
        String result = weatherPar.parWeatherData(json);
        assertEquals(expected, result);
    }

    @Test
    public void testParWeatherData_emptyDaysArray() {
        WeatherPar weatherPar = new WeatherPar();
        String json = """
                {
                    "city": "Moscow",
                    "days": []
                }
                """;

        String expected = "Нет такого бебебе.";
        String result = weatherPar.parWeatherData(json);
        assertEquals(expected, result);
    }

    @Test
    public void testParWeatherData_missingDaysArray() {
        WeatherPar weatherPar = new WeatherPar();
        String json = """
                {
                    "city": "Moscow"
                }
                """;

        String expected = "Нет такого бебебе.";
        String result = weatherPar.parWeatherData(json);
        assertEquals(expected, result);
    }

    @Test
    public void testParWeatherData_invalidJsonFormat() {
        WeatherPar weatherPar = new WeatherPar();
        String invalidJson = """
                {
                    "city": "Moscow",
                    "days": [
                        {
                            "datetime": "2025-09-19",
                            "temp": 12.0,
                            "conditions": "Дождь, Частично облачно"
                        }
                    """;

        assertThrows(org.json.JSONException.class, () -> {
            weatherPar.parWeatherData(invalidJson);
        });
    }

    @Test
    public void testParWeatherData_missingRequiredFieldInDay() {
        WeatherPar weatherPar = new WeatherPar();
        String json = """
                {
                    "city": "Moscow",
                    "days": [
                        {
                            "datetime": "2025-09-19",
                            "conditions": "Дождь, Частично облачно"
                        }
                    ]
                }
                """;
        assertThrows(org.json.JSONException.class, () -> {
            weatherPar.parWeatherData(json);
        });
    }

    @Test
    public void testParWeatherData_moreThanSevenDays() {
        WeatherPar weatherPar = new WeatherPar();
        String json = """
                {
                    "city": "Moscow",
                    "days": [
                        {
                            "datetime": "2025-09-19",
                            "temp": 12.0,
                            "conditions": "Day 1"
                        },
                        {
                            "datetime": "2025-09-20",
                            "temp": 13.0,
                            "conditions": "Day 2"
                        },
                        {
                            "datetime": "2025-09-21",
                            "temp": 16.0,
                            "conditions": "Day 3"
                        },
                        {
                            "datetime": "2025-09-22",
                            "temp": 19.0,
                            "conditions": "Day 4"
                        },
                        {
                            "datetime": "2025-09-23",
                            "temp": 18.0,
                            "conditions": "Day 5"
                        },
                        {
                            "datetime": "2025-09-24",
                            "temp": 12.0,
                            "conditions": "Day 6"
                        },
                        {
                            "datetime": "2025-09-25",
                            "temp": 7.0,
                            "conditions": "Day 7"
                        },
                        {
                            "datetime": "2025-09-26",
                            "temp": 8.0,
                            "conditions": "Day 8"
                        }
                    ]
                }
                """;

        String expected = """
                2025-09-19: 12°C, Day 1
                2025-09-20: 13°C, Day 2
                2025-09-21: 16°C, Day 3
                2025-09-22: 19°C, Day 4
                2025-09-23: 18°C, Day 5
                2025-09-24: 12°C, Day 6
                2025-09-25: 7°C, Day 7
                """;
        String result = weatherPar.parWeatherData(json);
        assertEquals(expected, result);
    }
}