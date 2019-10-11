package com.hjl.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-11
 * Time: 下午6:51
 * Description:
 */
@Activate(order = 1,group = {"order"})
public class OrderTwoExt implements Activateext{

    @Override
    public String echo(String message) {
        return "two";
    }
}
