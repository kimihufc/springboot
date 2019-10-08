package com.hjl.bootlearn.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-8
 * Time: 下午5:50
 * Description:
 */
@Component
public class Mycommand implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("*************CommandLineRunner************");
    }
}
