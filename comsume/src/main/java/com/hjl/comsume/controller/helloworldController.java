package com.hjl.comsume.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hjl.bean.Man;
import com.hjl.facade.Manfacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created   on 2018/8/21.
 *
 * @author hjl
 */
@RestController
public class helloworldController {

    @Reference(version = "1.0.0")
    private Manfacade manfacade;

    @RequestMapping("hello")
    public String hello(){
        Man gain = manfacade.gain();
        System.out.println(gain.toString());
        return "success";
    }
}
