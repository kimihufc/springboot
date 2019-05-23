package com.hjl.config;

import com.hjl.service.SayService;
import com.hjl.util.BeanTool;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-5-23
 * Time: 下午2:09
 * Description:
 */
public class HandlerContext {

    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public SayService getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type: " + type);
        }
        return (SayService) BeanTool.getBean(clazz);
    }

}
