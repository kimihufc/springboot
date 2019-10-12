package com.hjl.serial;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-12
 * Time: 下午6:02
 * Description:
 */
public class User implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
