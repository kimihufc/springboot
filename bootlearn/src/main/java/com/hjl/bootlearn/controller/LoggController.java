package com.hjl.bootlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-9-29
 * Time: 上午10:24
 * Description:
 */
@RestController
@RequestMapping(value = "log")
public class LoggController {

    private Logger logger = LoggerFactory.getLogger(LoggController.class);

    @Autowired
    private LoggingSystem loggingSystem;

    @GetMapping("hello")
    public String hello(){
        logger.debug("loggcontroller debug");
        return "success";
    }

    @GetMapping("modlog")
    public String modlog(){
        loggingSystem.setLogLevel("com.hjl.bootlearn.controller.LoggController", LogLevel.DEBUG);
        return "success";
    }

}
