package com.hjl;

import com.hjl.service.MainService;
import com.hjl.spi.MainSpiService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
//        MainService bean = applicationContext.getBean(MainService.class);
//        bean.say();
        ServiceLoader<MainSpiService> load = ServiceLoader.load(MainSpiService.class);

        for (MainSpiService mainSpiService : load) {
            mainSpiService.say();
        }

    }
}
