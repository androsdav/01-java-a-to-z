package com.adidyk.start;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
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
        JobDetail job = newJob(ParserSqlRuJob.class).build();
        Trigger trigger = newTrigger()
                .withIdentity("CronTrigger")
                .withSchedule(cronSchedule("0/20 * * * * ?"))
                .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
