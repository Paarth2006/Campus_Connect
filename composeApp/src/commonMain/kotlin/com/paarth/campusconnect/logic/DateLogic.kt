package com.paarth.campusconnect.logic

import com.paarth.campusconnect.model.WeekDay
import kotlin.time.Clock // Add this (Standard Library)
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun getTodayWeekDay(): WeekDay? {
    return when (
        Clock.System.now()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .dayOfWeek.name
    ) {
        "MONDAY" -> WeekDay.MONDAY
        "TUESDAY" -> WeekDay.TUESDAY
        "WEDNESDAY" -> WeekDay.WEDNESDAY
        "THURSDAY" -> WeekDay.THURSDAY
        "FRIDAY" -> WeekDay.FRIDAY
        else -> null // Weekend
    }
}
