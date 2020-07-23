package com.lml.qrzt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.lml.qrzt")
@SpringBootApplication
@EnableScheduling
public class QrztApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrztApplication.class, args);
    }

}
