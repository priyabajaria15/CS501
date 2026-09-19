package com.priyabajaria.cs501.focus_plan_builder.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimaryPurple,
    onPrimary = White,
    secondary = Coral,
    onSecondary = White,

    background = AppBackground,
    onBackground = TextPrimary,

    surface = CardWhite,
    onSurface = TextPrimary,

    primaryContainer = LightPurple,
    onPrimaryContainer = DarkPurple,

    secondaryContainer = LightSage,
    onSecondaryContainer = TextPrimary,

    surfaceVariant = PalePurple,
    onSurfaceVariant = TextSecondary,

    outline = SoftBorder
)

private val DarkColorScheme = darkColorScheme(
    primary = LightPurple,
    onPrimary = DarkPurple,
    secondary = Coral,
    onSecondary = TextPrimary,
    background = DarkBackground,
    onBackground = White,
    surface = DarkSurface,
    onSurface = White
)

@Composable
fun Focus_Plan_BuilderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) {
            DarkColorScheme
        } else {
            LightColorScheme
        },
        typography = Typography,
        content = content
    )
}