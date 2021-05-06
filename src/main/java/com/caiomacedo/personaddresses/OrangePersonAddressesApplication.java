package com.caiomacedo.personaddresses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrangePersonAddressesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangePersonAddressesApplication.class, args);
    }

}
