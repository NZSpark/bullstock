package com.seclib.bull.cat.demo.gateway.startup;

import com.dianping.cat.Cat;
import com.dianping.cat.CatConstants;
import com.dianping.cat.message.Transaction;
import com.seclib.bull.cat.demo.gateway.catutils.CatRestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.seclib")
@RestController
public class CatDemoGatewayApplication {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service2.address:localhost:8082}")
    private String serviceAddress;

    public static void main(String[] args) {
        SpringApplication.run(CatDemoGatewayApplication.class,args);
    }

    /**
     *
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/gateway")
    public String gateway() throws Exception{

        Thread.sleep(100);
        String response = restTemplate.getForObject("http://" + serviceAddress + "/order" ,String.class);
        return  "gateway response ==> " + response;
    }

    @RequestMapping("/timeout")
    public String timeout() throws Exception {
        Transaction t = Cat.newTransaction(CatConstants.TYPE_URL, "timeout");
        try {
            Thread.sleep(100);
            String response = restTemplate.getForObject("http://" + serviceAddress + "/timeout" ,String.class);
            return response;
        }catch (Exception e){
            Cat.getProducer().logError(e);
            t.setStatus(e);
            throw e;
        }finally {
            t.complete();
        }

    }

    @Bean
    RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();

        // 保存和传递调用链上下文
        restTemplate.setInterceptors(Collections.singletonList(new CatRestInterceptor()));

        return restTemplate;
    }


}
