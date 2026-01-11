package com.paarth.campusconnect.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paarth.campusconnect.ui.theme.AppThemeState
import com.paarth.campusconnect.ui.theme.ThemeOption

@Suppress("unused")
@Composable
fun SettingsScreen() {

    val selectedTheme by AppThemeState.theme
    var classReminders by remember { mutableStateOf(true) }
    var deadlineAlerts by remember { mutableStateOf(true) }
    var announcementNotifications by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        // Appearance
        SettingsSection(title = "Appearance")

        ThemeOption.entries.forEach { theme ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = selectedTheme == theme,
                        onClick = { AppThemeState.theme.value = theme }
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = theme.label)
                RadioButton(
                    selected = selectedTheme == theme,
                    onClick = { AppThemeState.theme.value = theme }
                )
            }
        }

        // Notifications
        SettingsSection(title = "Notifications")

        SettingsSwitch(
            title = "Class Reminders",
            checked = classReminders,
            onCheckedChange = { classReminders = it }
        )

        SettingsSwitch(
            title = "Deadline Alerts",
            checked = deadlineAlerts,
            onCheckedChange = { deadlineAlerts = it }
        )

        SettingsSwitch(
            title = "Announcements",
            checked = announcementNotifications,
            onCheckedChange = { announcementNotifications = it }
        )

        // App Infdo
        SettingsSection(title = "App Info")

        InfoRow(label = "App Name", value = "CampusConnect")
        InfoRow(label = "Version", value = "1.0.0")
        InfoRow(label = "Build", value = "Debug")
    }
}

/*Components */

@Composable
private fun SettingsSection(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium
    )
}

@Composable
private fun SettingsSwitch(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title)
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(text = value)
    }
}
