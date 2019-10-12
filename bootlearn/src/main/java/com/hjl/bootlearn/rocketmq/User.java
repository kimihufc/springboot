package com.hjl.bootlearn.rocketmq;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-12
 * Time: 下午2:39
 * Description:
 */
public class User implements Serializable  {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
