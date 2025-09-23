package com.example.weatherapp;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class SiteInerfaseTest {
    @Mock
    private SiteInerfase siteInerfase;
    @Test
    public void testFetchData() throws Exception {
        MockitoAnnotations.openMocks(this);
        String expRes = "Mocked res";
        when(siteInerfase.fetchData("https://example.com"))
                .thenReturn(expRes);
        String result = siteInerfase.fetchData("https://example.com");
        assertEquals(expRes, result);

    }
}
