package com.paarth.campusconnect.ui.about

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "About CampusConnect",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "CampusConnect is a student-focused mobile application designed to simplify everyday academic life by bringing essential campus information into one place.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "The app helps students stay organized by providing easy access to timetables, announcements, reminders, and profile details without relying on scattered messages or multiple platforms.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "The goal of CampusConnect is to reduce confusion, missed updates, and last-minute stress by presenting academic information in a clear and structured way. The app focuses on simplicity, clarity, and usability.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Development Information",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Developed by: Paarth Singh",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Role: Student Developer",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Version: 1.0.0",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Disclaimer",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "CampusConnect is not an official university application. It is a student-developed project created for learning and demonstration purposes.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
