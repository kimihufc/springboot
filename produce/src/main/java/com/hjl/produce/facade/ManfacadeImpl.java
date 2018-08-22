package com.hjl.produce.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.hjl.bean.Man;
import com.hjl.facade.Manfacade;

/**
 * Created   on 2018/8/21.
 *
 * @author hjl
 */
@Service(version = "1.0.0")
public class ManfacadeImpl implements Manfacade{

    @Override
    public Man gain() {
        Man man = new Man();
        man.setName("kimi");
        man.setAge(12);
        return man;
    }
}
