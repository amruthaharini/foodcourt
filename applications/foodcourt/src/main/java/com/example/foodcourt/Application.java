package com.example.foodcourt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import com.example.foodcourt.beveragesui.ActionServlet;
import com.example.foodcourt.beveragesui.BeverageClient;
import com.example.foodcourt.appetizersui.AppetizerClient;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication(exclude= {io.pivotal.spring.cloud.IssuerCheckConfiguration.class})
public class Application {



    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
    @LoadBalanced
    @Bean
    public ServletRegistrationBean registerActionServlet(ActionServlet actionServlet) {
        return new ServletRegistrationBean(actionServlet, "/beveragesmenu/*");
    }




    @Bean
    public BeverageClient beverageClient(RestOperations restOperations) {
        return new BeverageClient("//beverages-ms/beverages", restOperations);
    }

    @Bean
    public AppetizerClient appetizerClient(RestOperations restOperations) {
        return new AppetizerClient("//appetizers-ms/appetizers", restOperations);
    }
}