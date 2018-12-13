package com.hjl.produce;

import com.hjl.produce.contextinit.ContextInit3;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.retry.annotation.EnableRetry;

import java.io.IOException;
import java.util.Properties;

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
        Resource resource = new ClassPathResource("test.properties");
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadProperties(resource);
            System.out.println(properties.getProperty("name"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
