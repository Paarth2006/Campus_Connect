package com.paarth.campusconnect.model

data class ClassSession(
    val subjectCode: String,
    val subjectName: String,
    val day: WeekDay,
    val startTime: String,
    val endTime: String,
    val location: String,
    val type: SessionType
)

enum class SessionType {
    LECTURE,
    LAB,
    LUNCH,
    PLACEMENT,
    EMPTY
}
