package com.raca.ms_item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@RibbonClient(name="feign-client-product")
@EnableFeignClients
@SpringBootApplication
public class MsItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsItemApplication.class, args);
    }

}
