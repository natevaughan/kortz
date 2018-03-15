@file:JvmName("App")

package com.natevaughan.kortz

import org.quartz.impl.StdSchedulerFactory
import org.slf4j.LoggerFactory

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val log = LoggerFactory.getLogger(App::class.java)
        log.info("Starting Kortz scheduler. Press any key to quit.")
        val scheduler = StdSchedulerFactory.getDefaultScheduler()
        scheduler.start()
        System.`in`.read()
    }
}