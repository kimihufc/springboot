package com.hjl.bean;

import java.io.Serializable;

/**
 * Created   on 2018/8/21.
 *
 * @author hjl
 */
public class Man implements Serializable{

    private Integer age;

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
