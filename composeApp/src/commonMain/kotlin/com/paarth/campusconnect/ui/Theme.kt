package com.paarth.campusconnect.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.paarth.campusconnect.ui.theme.AppThemeState
import com.paarth.campusconnect.ui.theme.ThemeOption

private val LightColors = lightColorScheme(
    primary = Primary,
    onPrimary = Surface,
    background = Background,
    onBackground = Primary,
    surface = Surface,
    onSurface = Primary,
    secondary = Secondary,
    outline = Divider
)

private val DarkColors = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = SurfaceDark,
    background = BackgroundDark,
    onBackground = PrimaryDark,
    surface = SurfaceDark,
    onSurface = PrimaryDark,
    secondary = SecondaryDark,
    outline = DividerDark
)

@Composable
fun CampusTheme(content: @Composable () -> Unit) {
    val themeOption by AppThemeState.theme
    
    val useDarkTheme = when (themeOption) {
        ThemeOption.LIGHT -> false
        ThemeOption.DARK -> true
        ThemeOption.SYSTEM -> isSystemInDarkTheme()
    }

    MaterialTheme(
        colorScheme = if (useDarkTheme) DarkColors else LightColors,
        content = content
    )
}
