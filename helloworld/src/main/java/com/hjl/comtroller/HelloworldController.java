package com.hjl.comtroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created   on 2018/8/21.
 *
 * @author hjl
 */
@RestController
public class HelloworldController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
