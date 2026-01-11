package com.paarth.campusconnect.logic

import com.paarth.campusconnect.model.Deadline
import kotlinx.datetime.LocalDate

fun reminderMessage(deadline: Deadline, today: LocalDate): String? {
    val daysLeft = deadline.dueDate.toEpochDays() - today.toEpochDays()

    return when {
        daysLeft == 0L -> "Due today"
        daysLeft == 1L -> "Due tomorrow"
        daysLeft in 2L..3L -> "Due in $daysLeft days"
        else -> null
    }
}
