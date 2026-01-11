package com.paarth.campusconnect

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalInspectionMode
import com.paarth.campusconnect.ui.auth.AuthState
import com.paarth.campusconnect.ui.auth.LoginScreen
import com.paarth.campusconnect.ui.navigation.MainScreen
import com.paarth.campusconnect.ui.theme.AppThemeState
import com.paarth.campusconnect.ui.theme.ThemeOption

@Composable
fun App() {
    val theme by AppThemeState.theme
    val isLoggedIn by AuthState.isLoggedIn

    val darkTheme = when (theme) {
        ThemeOption.SYSTEM -> !LocalInspectionMode.current &&
                androidx.compose.foundation.isSystemInDarkTheme()
        ThemeOption.DARK -> true
        ThemeOption.LIGHT -> false
    }

    MaterialTheme(
        colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    ) {
        if (isLoggedIn) {
            MainScreen()
        } else {
            LoginScreen()
        }
    }
}
