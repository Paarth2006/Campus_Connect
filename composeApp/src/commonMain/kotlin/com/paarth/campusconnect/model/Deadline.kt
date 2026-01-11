package com.paarth.campusconnect.model

import kotlinx.datetime.LocalDate

data class Deadline(
    val title: String,
    val dueDate: LocalDate
)
