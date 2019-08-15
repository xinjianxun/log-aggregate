package com.aioria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LogEurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(LogEurekaApp.class,args);
    }
}
