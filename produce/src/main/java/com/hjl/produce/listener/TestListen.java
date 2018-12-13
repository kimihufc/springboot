package com.hjl.produce.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author: HJL
 * @create: 2018-12-13 14:07
 */
public class TestListen implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.err.println("starting . . . . . . . . . .");
    }
}
