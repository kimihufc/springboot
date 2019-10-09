package com.hjl.bootlearn.controller;

import com.hjl.bootlearn.springcore.MyFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-9
 * Time: 下午12:00
 * Description:
 */
@RestController
public class TestController implements ApplicationContextAware {


    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
          this.applicationContext = applicationContext;
    }

    @GetMapping(value = "test")
    public String test() throws Exception{
        MyFactoryBean  factoryBean = (MyFactoryBean)applicationContext.getBean("&myFactoryBean");
        factoryBean.setType("car");
        System.out.println(factoryBean.getObject());
        Object myFactoryBean = applicationContext.getBean("myFactoryBean");
        System.out.println(myFactoryBean.getClass().getName());
        return "success";
    }
}
