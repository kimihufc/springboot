package com.hjl.reference;


import com.hjl.service.ProxyFactory;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-11
 * Time: 下午3:21
 * Description:
 */
public class ReferenceConfig<T> {

    private Class<?> interfaceClass;
    // 接口代理类引用
    private transient volatile T ref;
    public synchronized T get() {
        if (ref == null) {
            init();
        }
        return ref;
    }
    private void init() {
        ref = new ProxyFactory(interfaceClass).getproxzObject();
    }
    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }
    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
}
