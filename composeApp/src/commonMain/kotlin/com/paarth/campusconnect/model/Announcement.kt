package com.paarth.campusconnect.model

import kotlinx.datetime.LocalDate

data class Announcement(
    val title: String,
    val message: String,
    val date: LocalDate,
    val type: AnnouncementType
)

enum class AnnouncementType {
    ACADEMIC,
    EXAM,
    ADMIN,
    PLACEMENT,
    EVENT
}
