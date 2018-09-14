package com.hjl.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created   on 2018/8/21.
 *
 * @author hjl
 */
@SpringBootApplication
@EnableRetry
public class StartUp {

    public static void main(String[] args) {
        SpringApplication.run(StartUp.class,args);
    }

}
