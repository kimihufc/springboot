package com.hjl.service.impl;

import com.hjl.annotation.HandlerType;
import com.hjl.service.SayService;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-5-23
 * Time: 上午11:41
 * Description:
 */
@HandlerType("cat")
public class CatSayImpl implements SayService {

    @Override
    public void say(String name) {
        System.out.println("name:"+name);
    }
}
