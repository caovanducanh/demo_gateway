package com.example.gateway;

import com.example.gateway.config.DotenvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        DotenvLoader.loadEnv();
        SpringApplication.run(GatewayApplication.class, args);
    }
}
