package com.hjl.service.impl;

import com.hjl.annotation.HandlerType;
import com.hjl.service.SayService;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-5-23
 * Time: 下午2:05
 * Description:
 */
@HandlerType("dog")
public class DogSayImpl implements SayService {

    @Override
    public void say(String name) {
        System.out.println("dog:"+name);
    }
}
