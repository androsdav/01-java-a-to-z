package com.adidyk.start;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.Date;

public class HelloJob implements Job {

    private String message = "say hello";

    HelloJob() {

    }

    /**
     *
     */
    public void sayHello() {
        System.out.println(this.message);
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello World! - " + new Date());
    }

}
