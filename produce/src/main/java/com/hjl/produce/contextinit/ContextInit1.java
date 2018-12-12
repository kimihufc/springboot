package com.hjl.produce.contextinit;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: HJL
 * @create: 2018-12-12 19:47
 */
public class ContextInit1 implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ContextInit1***** *****");
    }
}
