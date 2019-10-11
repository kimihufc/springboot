package com.hjl;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.hjl.activate.Activateext;
import com.hjl.service.MainService;
import com.hjl.spi.MainSpiService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
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


//        ServiceLoader<MainSpiService> load = ServiceLoader.load(MainSpiService.class);
//
//        for (MainSpiService mainSpiService : load) {
//            mainSpiService.say();
//        }

        ExtensionLoader<Activateext> loader = ExtensionLoader.getExtensionLoader(Activateext.class);
        URL url = URL.valueOf("test");
        List<Activateext> extension = loader.getActivateExtension(url, new String[]{}, "default");
        System.out.println(extension.get(0).echo("hello"));
        List<Activateext> group = loader.getActivateExtension(url, new String[]{}, "one");
        System.out.println(group.get(0).echo("hello"));
        List<Activateext> order = loader.getActivateExtension(url, new String[]{}, "order");
        System.out.println(order.get(0).echo("hello"));
        System.out.println(order.get(1).echo("hello"));
    }
}
