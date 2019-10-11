package com.hjl.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-11
 * Time: 下午3:33
 * Description:
 */
public class ProxyFactory implements InvocationHandler {

    private Class interfaceclass;

    public ProxyFactory(Class interfaceclass) {
        this.interfaceclass = interfaceclass;
    }

    public <T> T getproxzObject(){
        return (T) Proxy.newProxyInstance(this.interfaceclass.getClassLoader(),
                new Class[]{interfaceclass},
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始网络调用");
        return null;
    }
}
