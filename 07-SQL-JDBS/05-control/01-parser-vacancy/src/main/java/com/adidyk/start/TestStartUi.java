package com.adidyk.start;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class TestStartUi {

    public static void main(String[] args) throws InterruptedException, SchedulerException {
        JobDetail job = newJob(HelloJob.class).build();
        Trigger trigger = newTrigger()
                .withIdentity("CronTrigger")
                .withSchedule(cronSchedule("0/20 * * * * ?"))
                .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);


        //Thread.sleep(1000);
        //scheduler.shutdown();
        //Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        //SimpleExample simpleExample = new SimpleExample();

       // simpleExample.task();
    }

}
