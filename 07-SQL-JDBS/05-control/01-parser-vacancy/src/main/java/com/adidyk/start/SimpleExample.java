package com.adidyk.start;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.DateBuilder.evenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SimpleExample {

    public void task() throws SchedulerException, InterruptedException {
        //scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //job
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();
        //trigger
        Date runTime = evenSecondDate(new Date());
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(runTime)
                .build();
        //
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
        //Thread.sleep(90L * 1000L);
        scheduler.shutdown(true);
    }


}
