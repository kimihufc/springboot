package com.hjl;

import com.hjl.service.MainService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        MainService bean = applicationContext.getBean(MainService.class);
        bean.say();
    }
}
