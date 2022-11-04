package com.trendyol.meetup.api

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class KotlinSpringBootApiApplicationIT {
    @Test
    fun it_should_test_application_running_properly()=KotlinMain.main(arrayOf("test"))
}