@file:JvmName("App")

package com.natevaughan.kortz

import org.quartz.JobBuilder.newJob
import org.quartz.JobDetail
import org.quartz.Scheduler
import org.quartz.SchedulerException
import org.quartz.SimpleScheduleBuilder.simpleSchedule
import org.quartz.Trigger
import org.quartz.TriggerBuilder.newTrigger
import org.quartz.impl.StdSchedulerFactory
import org.slf4j.LoggerFactory


object App {

    private val log = LoggerFactory.getLogger(App::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        val scheduler: Scheduler? = null
        try {
            log.info("Starting Kortz scheduler. Press any key to quit.")
            val scheduler = StdSchedulerFactory.getDefaultScheduler()
            scheduler.start()
            val job: JobDetail = newJob(HelloJob::class.java)
                    .withIdentity("job1", "group1")
                    .build()

            val trigger: Trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(40)
                            .repeatForever())
                    .build()

            // Tell quartz to schedule the job using our trigger
            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger)
            System.`in`.read()
        } catch (se: SchedulerException) {
            log.info("Scheduler exception encountered: ", se)
        } finally {
            scheduler?.shutdown()
        }
        log.info("Thank you for using Kortz. Come again!")
    }
}