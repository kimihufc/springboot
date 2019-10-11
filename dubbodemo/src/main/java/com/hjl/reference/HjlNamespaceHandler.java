package com.hjl.reference;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-11
 * Time: 下午3:31
 * Description:
 */
public class HjlNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("reference",new HjlBeanDefinitionParser());
    }
}
