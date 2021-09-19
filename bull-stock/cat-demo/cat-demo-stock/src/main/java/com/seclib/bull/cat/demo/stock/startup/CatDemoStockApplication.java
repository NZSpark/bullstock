package com.seclib.bull.cat.demo.stock.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.seclib")
@RestController
public class CatDemoStockApplication {

    @RequestMapping("/stock")
    public String stock() throws Exception{
        Thread.sleep(100);
        return "stock success.";
    }
    public static void main(String[] args) {
        SpringApplication.run(CatDemoStockApplication.class,args);
    }
}
