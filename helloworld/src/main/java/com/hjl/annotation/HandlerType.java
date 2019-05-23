package com.hjl.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-5-23
 * Time: 下午2:00
 * Description:  处理类型
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HandlerType {

    String value();
}
