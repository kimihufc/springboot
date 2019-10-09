package com.hjl.bootlearn.springcore;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-9
 * Time: 上午11:42
 * Description:
 */
@Component
public class MyFactoryBean implements FactoryBean {

    private String type="host";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Object getObject() throws Exception {
        if("car".equals(type)){
            return new Car();
        }
        return new Host();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
