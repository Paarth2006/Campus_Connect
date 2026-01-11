package com.paarth.campusconnect.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.paarth.campusconnect.ui.about.AboutScreen
import com.paarth.campusconnect.ui.announcements.AnnouncementsScreen
import com.paarth.campusconnect.ui.help_support.HelpSupportScreen
import com.paarth.campusconnect.ui.home.HomeScreen
import com.paarth.campusconnect.ui.profile.ProfileScreen
import com.paarth.campusconnect.ui.settings.SettingsScreen

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    var showAboutScreen by remember { mutableStateOf(false) }
    var showSettingsScreen by remember { mutableStateOf(false) }
    var showHelpSupportScreen by remember { mutableStateOf(false) }

    val title = when {
        showAboutScreen -> "About Us"
        showSettingsScreen -> "Settings"
        showHelpSupportScreen -> "Help & Support"
        selectedTab == 0 -> "Home"
        selectedTab == 1 -> "Announcements"
        selectedTab == 2 -> "Profile"
        else -> ""
    }

    Scaffold(
        bottomBar = {
            if (!showAboutScreen && !showSettingsScreen && !showHelpSupportScreen) {
                BottomNav(
                    selectedIndex = selectedTab,
                    onTabSelected = { selectedTab = it }
                )
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            TopHeader(
                title = title,
                onBackClick = when {
                    showAboutScreen -> { { showAboutScreen = false } }
                    showSettingsScreen -> { { showSettingsScreen = false } }
                    showHelpSupportScreen -> { { showHelpSupportScreen = false } }
                    else -> null
                }
            )

            when {
                showAboutScreen -> AboutScreen()
                showSettingsScreen -> SettingsScreen()
                showHelpSupportScreen -> HelpSupportScreen()
                selectedTab == 0 -> HomeScreen()
                selectedTab == 1 -> AnnouncementsScreen()
                selectedTab == 2 -> ProfileScreen(
                    onAboutClick = { showAboutScreen = true },
                    onSettingsClick = { showSettingsScreen = true },
                    onHelpSupportClick = { showHelpSupportScreen = true }
                )
            }
        }
    }
}
