package com.example.foodcourt.appetizersui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

public class AppetizerClient {
    private static ParameterizedTypeReference<List<AppetizerUI>> appetizerListType = new ParameterizedTypeReference<List<AppetizerUI>>() {
    };
    private String appetizerURL;
    private RestOperations restOperations;
    private static final int CACHE_SIZE = 5;
    private final List<AppetizerUI> lastRead = new ArrayList<>(CACHE_SIZE);
    private static final Logger log = LoggerFactory.getLogger(AppetizerClient.class);

    public AppetizerClient(String appetizerURL, RestOperations restOperations) {
        this.appetizerURL = appetizerURL;
        this.restOperations = restOperations;
    }

    public void create(AppetizerUI appetizer) {
        restOperations.postForEntity(appetizerURL, appetizer, AppetizerUI.class);
    }


    @HystrixCommand(fallbackMethod="getAllFallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    })
    public List<AppetizerUI> getAll() {
        List<AppetizerUI> read = restOperations.exchange(appetizerURL, HttpMethod.GET, null, appetizerListType).getBody();
        log.debug("Read {} appetizers from {}", read.size(), appetizerURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++)
            lastRead.add(read.get(i));
        log.debug("Copied {} appetizers into the cache", copyCount);

        return read;
    }

    public List<AppetizerUI> getAllFallback() {
        log.debug("Returning {} appetizers from the fallback method", lastRead.size());

        return lastRead;
    }
}