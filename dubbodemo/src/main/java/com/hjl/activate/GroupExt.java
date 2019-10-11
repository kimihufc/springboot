package com.hjl.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-11
 * Time: 下午6:50
 * Description:
 */
@Activate(group = {"one","two"})
public class GroupExt implements Activateext {
    @Override
    public String echo(String message) {
        return "message";
    }
}
