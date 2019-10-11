package com.hjl.spi;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-11
 * Time: 下午4:49
 * Description:
 */
public class OneServiceImpl implements MainSpiService {

    @Override
    public void say() {
        System.out.println("one *****");
    }
}
