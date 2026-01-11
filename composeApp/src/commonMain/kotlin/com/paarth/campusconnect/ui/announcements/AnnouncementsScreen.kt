package com.paarth.campusconnect.ui.announcements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paarth.campusconnect.model.Announcement
import com.paarth.campusconnect.model.AnnouncementType
import com.paarth.campusconnect.repository.CampusRepository

@Suppress("unused")
@Composable
fun AnnouncementsScreen() {

    val repo = CampusRepository()
    val announcements = repo.getAnnouncements()
    val grouped = announcements.groupBy { it.type }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        grouped.forEach { (type, items) ->
            item {
                AnnouncementSection(
                    type = type,
                    announcements = items.sortedByDescending { it.date }
                )
            }
        }
    }
}

@Composable
private fun AnnouncementSection(
    type: AnnouncementType,
    announcements: List<Announcement>
) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        shape = MaterialTheme.shapes.large,
        tonalElevation = 1.dp,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { expanded = !expanded },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = type.displayName(),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null
                )
            }

            val visibleItems = if (expanded) announcements else announcements.take(1)

            visibleItems.forEach { announcement ->
                HorizontalDivider()
                AnnouncementItem(announcement)
            }
        }
    }
}

@Composable
private fun AnnouncementItem(announcement: Announcement) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = announcement.title,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = announcement.message,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 2
        )

        Text(
            text = announcement.date.toString(),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

private fun AnnouncementType.displayName(): String =
    when (this) {
        AnnouncementType.ACADEMIC -> "Academics"
        AnnouncementType.EXAM -> "Exams"
        AnnouncementType.ADMIN -> "Administration"
        AnnouncementType.PLACEMENT -> "Placements"
        AnnouncementType.EVENT -> "Events"
    }
