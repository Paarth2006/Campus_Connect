package com.paarth.campusconnect.logic

import com.paarth.campusconnect.model.Deadline
import kotlinx.datetime.LocalDate

fun upcomingDeadlines(
    deadlines: List<Deadline>,
    today: LocalDate
): List<Deadline> {
    return deadlines
        .filter { it.dueDate >= today }
        .sortedBy { it.dueDate }
}
