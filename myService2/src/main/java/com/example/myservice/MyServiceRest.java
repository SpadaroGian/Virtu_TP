package com.example.myservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class MyServiceRest {

    private final RestTemplate restTemplate;

    @Value("${service.url:}")
    private String serviceUrl;

    public MyServiceRest() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/")
    public String sayHello(){
        String content = restTemplate.getForObject(serviceUrl, String.class);
        return "Hello " + content;
    }

}
