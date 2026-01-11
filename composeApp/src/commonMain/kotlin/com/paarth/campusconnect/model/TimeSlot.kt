package com.paarth.campusconnect.model

data class TimeSlot(
    val start: String,
    val end: String
)
val DAILY_TIME_SLOTS = listOf(
    TimeSlot("08:00", "08:55"),
    TimeSlot("09:00", "09:55"),
    TimeSlot("09:55", "10:50"),
    TimeSlot("11:10", "12:05"),
    TimeSlot("12:05", "13:00"),
    TimeSlot("13:00", "13:55"),
    TimeSlot("13:55", "14:50"),
    TimeSlot("15:10", "16:05"),
    TimeSlot("16:05", "17:00"),
    TimeSlot("17:00", "17:55")
)
