package com.example.foodcourt;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class IntegrationTest {

    @Test
    public void appetizerTest() {

        RestTemplate restTemplate = new RestTemplate();

        String homePage = restTemplate.getForObject(url("/"), String.class);

        assertThat(homePage, containsString("Please select one of the following links:"));

        String setupPage = restTemplate.getForObject(url("/setup"), String.class);

        assertThat(setupPage, containsString("TED Radio Hour"));
        assertThat(setupPage, containsString("Fresh Air"));

        String appetizerTest = restTemplate.getForObject(url("/appetizers"), String.class);

        assertThat(appetizerTest, containsString("TED Radio Hour"));
        assertThat(appetizerTest, containsString("Fresh Air"));
    }

    private String url(String path) {
        String baseUrl = "http://localhost:8080/";
        String envUrl = System.getenv("FOODCOURT_URL");

        if (envUrl != null && !envUrl.isEmpty()) {
            baseUrl = envUrl;
        }

        return baseUrl + path;
    }
}
