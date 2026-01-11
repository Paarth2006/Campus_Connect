package com.paarth.campusconnect.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextOverflow
import com.paarth.campusconnect.logic.getTodayWeekDay
import com.paarth.campusconnect.logic.reminderMessage
import com.paarth.campusconnect.model.*
import com.paarth.campusconnect.repository.CampusRepository
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import kotlin.time.Clock
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val repo = CampusRepository()
    val weeklyTimetable = repo.getWeeklyTimetable()
    val deadlines = repo.getDeadlines()

    val defaultDay = getTodayWeekDay() ?: WeekDay.MONDAY
    var selectedDay by remember { mutableStateOf(defaultDay) }

    val dayClasses = weeklyTimetable.filter { it.day == selectedDay }
    
    // Using actual current date from the system clock
    val todayDate = remember {
        Clock.System.todayIn(TimeZone.currentSystemDefault())
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {

        item {
            SectionTitle("${selectedDay.name.lowercase().replaceFirstChar { it.uppercase() }} Timetable")
        }

        item {
            DaySelector(
                selectedDay = selectedDay,
                onDaySelected = { selectedDay = it }
            )
        }

        item {
            TimetableSection(dayClasses)
        }

        item {
            SectionTitle("Upcoming Deadlines")
        }

        item {
            DeadlinesSection(deadlines, todayDate)
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun DaySelector(
    selectedDay: WeekDay,
    onDaySelected: (WeekDay) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        WeekDay.entries.forEach { day ->
            FilterChip(
                selected = day == selectedDay,
                onClick = { onDaySelected(day) },
                label = { Text(day.name.take(3)) }
            )
        }
    }
}

@Composable
fun TimetableSection(timetable: List<ClassSession>) {
    Surface(
        shape = MaterialTheme.shapes.large,
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            timetable.forEach { session ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {

                        Text(
                            text = "${session.startTime} – ${session.endTime}",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            text = session.subjectName,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    if (session.location.isNotEmpty()) {
                        Text(
                            text = session.location,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DeadlinesSection(
    deadlines: List<Deadline>,
    today: LocalDate
) {
    Surface(
        shape = MaterialTheme.shapes.large,
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            deadlines.forEach { deadline ->

                val reminder = reminderMessage(deadline, today)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            text = deadline.title,
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Text(
                            text = "Due ${deadline.dueDate}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    if (reminder != null) {
                        Surface(
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .widthIn(min = 84.dp),
                            color = when {
                                reminder.contains("today", true) ->
                                    MaterialTheme.colorScheme.errorContainer
                                reminder.contains("tomorrow", true) ->
                                    MaterialTheme.colorScheme.secondaryContainer
                                else ->
                                    MaterialTheme.colorScheme.surfaceVariant
                            },
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(
                                text = when {
                                    reminder.contains("today", true) -> "Today"
                                    reminder.contains("tomorrow", true) -> "Tomorrow"
                                    else -> "Soon"
                                },
                                modifier = Modifier.padding(
                                    horizontal = 10.dp,
                                    vertical = 6.dp
                                ),
                                style = MaterialTheme.typography.labelMedium,
                                textAlign = TextAlign.Center,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }
    }
}
