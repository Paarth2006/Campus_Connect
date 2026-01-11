package com.paarth.campusconnect.ui.help_support

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Suppress("unused")
@Composable
fun HelpSupportScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "Help & Support",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        // Getting Started
        HelpSection(title = "Getting Started")

        ExpandableItem(
            question = "How do I log in?",
            answer = "Use the provided login credentials to access the app."
        )

        ExpandableItem(
            question = "What can I do in CampusConnect?",
            answer = "You can view your academic details, manage reminders, check announcements, and customize app settings."
        )

        //Common Issues
        HelpSection(title = "Common Issues")

        ExpandableItem(
            question = "I’m not receiving notifications",
            answer = "Make sure notifications are enabled for CampusConnect in your device settings."
        )

        ExpandableItem(
            question = "Theme changes are not applied",
            answer = "If the theme does not update immediately, try restarting the app."
        )

        ExpandableItem(
            question = "App content is not updating",
            answer = "Close and reopen the app to refresh the content."
        )

        // FAQs
        HelpSection(title = "FAQs")

        ExpandableItem(
            question = "Is CampusConnect an official university app?",
            answer = "No, CampusConnect is a student-developed project and is not an official university application."
        )

        ExpandableItem(
            question = "Is my data shared with anyone?",
            answer = "No. All data is stored locally on your device and is not shared with third parties."
        )

        ExpandableItem(
            question = "Does this app work offline?",
            answer = "Yes, most features of CampusConnect are available offline."
        )

        ExpandableItem(
            question = "Can I edit my academic details?",
            answer = "No, academic details are read-only and cannot be edited by users."
        )

        ExpandableItem(
            question = "Will more features be added?",
            answer = "Yes, CampusConnect is actively being improved with new features and enhancements."
        )

        // Contact and Feedback
        HelpSection(title = "Contact & Feedback")

        Text(
            text = "If you need help or want to share feedback, you can reach out using the details below.",
            style = MaterialTheme.typography.bodyMedium
        )

        InfoRow(label = "Email", value = "paarthsingh.33@gmail.com")
        InfoRow(label = "Feedback", value = "Send suggestions to help improve the app")
    }
}

/* other Compontents*/

@Composable
private fun HelpSection(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
private fun ExpandableItem(
    question: String,
    answer: String
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = question,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.weight(1f)
                )

                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = Icons.Default.ExpandMore,
                        contentDescription = null
                    )
                }
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = answer,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}