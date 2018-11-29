package com.adidyk.start;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashSet;
import java.util.Set;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 *
 */
public class CronTriggerRunner {

    /**
     *
     * @throws SchedulerException - is.
     */
    public void runner() throws SchedulerException {
        //SchedulerFactory factory = new StdSchedulerFactory();
        //Scheduler scheduler = factory.getScheduler();
        /*
        JobDetail job = newJob(ParserSqlRuJob.class).build();
        Trigger trigger = newTrigger()
                .withIdentity("CronTrigger")
                .startNow()
                .withSchedule(cronSchedule("0/30 * * * * ?"))
                .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
        */

        JobDetail job = newJob(ParserSqlRuJob.class).build();

        Set<Trigger> triggers = new HashSet<>();
        Trigger triggerStartNow = newTrigger()
                .withIdentity("TriggerStartNow")
                .startNow()
                .build();
        Trigger cronTrigger = newTrigger()
                .withIdentity("CronTrigger")
                .startNow()
                .withSchedule(cronSchedule("0/30 * * * * ?"))
                .build();
        triggers.add(triggerStartNow);
        triggers.add(cronTrigger);
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, triggers, false);
    }
}
