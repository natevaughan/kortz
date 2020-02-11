package com.natevaughan.kortz

import org.quartz.Job
import org.quartz.JobExecutionContext
import org.slf4j.LoggerFactory

class HelloJob: Job {
	companion object {
		private val log = LoggerFactory.getLogger(HelloJob::class.java)
	}
	override fun execute(context: JobExecutionContext?) {
		log.info("Hello! ${System.currentTimeMillis()}")
	}
}