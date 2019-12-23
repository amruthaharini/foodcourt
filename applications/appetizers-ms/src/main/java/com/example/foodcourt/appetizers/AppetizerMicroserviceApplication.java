package com.example.foodcourt.appetizers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class AppetizerMicroserviceApplication {

    public static void main(String... args) {
        SpringApplication.run(AppetizerMicroserviceApplication.class, args);
    }


}