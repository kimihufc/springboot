package com.hjl.bootlearn.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-9-29
 * Time: 上午10:39
 * Description:
 */
@RestController
@RequestMapping("valite")
@Validated
public class ValiteController {


    @GetMapping(value = "notnull")
    public String notnull(@NotNull(message = "name is not null") String name){
        return "success";
    }


}
