package com.hjl.produce;

import com.hjl.produce.contextinit.ContextInit3;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.hjl.produce.mapper")
public class StartUp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StartUp.class);
        application.addInitializers(new ContextInit3());
        application.run(args);
    }

}
