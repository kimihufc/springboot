package com.hjl.bootlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-9-29
 * Time: 上午10:23
 * Description:
 */
@SpringBootApplication
@Configuration
public class BootMain {

    public static void main(String[] args) {
        SpringApplication.run(BootMain.class,args);
    }
}
