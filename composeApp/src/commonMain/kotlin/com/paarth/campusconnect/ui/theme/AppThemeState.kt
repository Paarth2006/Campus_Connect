package com.paarth.campusconnect.ui.theme

import androidx.compose.runtime.mutableStateOf

enum class ThemeOption(val label: String) {
    SYSTEM("System Default"),
    LIGHT("Light"),
    DARK("Dark")
}

object AppThemeState {
    val theme = mutableStateOf(ThemeOption.SYSTEM)
}
