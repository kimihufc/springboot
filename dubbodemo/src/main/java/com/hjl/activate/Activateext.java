package com.hjl.activate;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-11
 * Time: 下午6:46
 * Description:
 */
@SPI
public interface Activateext {

    String echo(String message);
}
