package com.seclib.bull.cat.demo.account.startup;

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
public class CatDemoAccountApplication {

    @RequestMapping("/account")
    public String account() throws Exception{
        Thread.sleep(100);
        return "account success.";
    }


    public static void main(String[] args) {
        SpringApplication.run(CatDemoAccountApplication.class,args);
    }
}
