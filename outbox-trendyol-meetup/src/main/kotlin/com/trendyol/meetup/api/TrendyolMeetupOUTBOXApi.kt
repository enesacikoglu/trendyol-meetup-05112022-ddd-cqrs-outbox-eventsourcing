package com.trendyol.meetup.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrendyolMeetupOUTBOXApi

object KotlinMain {
    @JvmStatic
    fun main(args: Array<String>) {
        runApplication<TrendyolMeetupOUTBOXApi>(*args)
    }
}