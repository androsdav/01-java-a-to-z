package com.adidyk.start;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class TestStartUi {

    public static void main(String[] args) throws InterruptedException, SchedulerException {
        // job
        JobDetail job = JobBuilder.newJob(HelloJob.class).build();
        // trigger
        //Trigger trigger = TriggerBuilder.newTrigger()
        //        .withIdentity("SimpleTrigger")
        //        .startNow()
        //        .build();
        Trigger trigger = newTrigger()
                .withIdentity("CronTrigger")
                .withSchedule(cronSchedule("1/3 * * * * ?"))
                .build();
        // scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);

        //Thread.sleep(1000);
        //scheduler.shutdown();
        //Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        //SimpleExample simpleExample = new SimpleExample();

       // simpleExample.task();
    }

}
