package com.adidyk.start;

import org.quartz.SchedulerException;

public class TestStartUi {

    public static void main(String[] args) throws InterruptedException, SchedulerException {
        SimpleExample simpleExample = new SimpleExample();
        simpleExample.task();
    }

}
