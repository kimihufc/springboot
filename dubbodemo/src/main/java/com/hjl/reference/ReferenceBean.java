package com.hjl.reference;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-11
 * Time: 下午3:21
 * Description:
 */
public class ReferenceBean<T> extends ReferenceConfig<T> implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return get();
    }

    @Override
    public Class<?> getObjectType() {
        return getInterfaceClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
