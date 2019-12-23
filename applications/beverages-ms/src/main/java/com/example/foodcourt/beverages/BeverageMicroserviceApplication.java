package com.example.foodcourt.beverages;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BeverageMicroserviceApplication  {

    public static void main(String... args) {
        SpringApplication.run(BeverageMicroserviceApplication.class, args);
    }


}
