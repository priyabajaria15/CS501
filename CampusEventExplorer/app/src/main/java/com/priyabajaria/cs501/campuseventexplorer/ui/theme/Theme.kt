package com.priyabajaria.cs501.campuseventexplorer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val LightColors = lightColorScheme(
    primary = Scarlet40,
    onPrimary = Color.White,
    primaryContainer = Scarlet90,
    onPrimaryContainer = Scarlet10,
    secondary = Slate40,
    secondaryContainer = Slate90,
    onSecondaryContainer = Slate10,
    background = Sand99,
    onBackground = Ink10,
    surface = Sand99,
    onSurface = Ink10,
    surfaceVariant = Sand95,
    surfaceContainerLow = Color.White,
    surfaceContainer = Sand95,
)

private val DarkColors = darkColorScheme(
    primary = Scarlet80,
    onPrimary = Scarlet10,
    primaryContainer = Color(0xFF93000A),
    onPrimaryContainer = Scarlet90,
    secondary = Slate80,
    secondaryContainer = Slate40,
    onSecondaryContainer = Slate90,
    background = Night6,
    onBackground = Color(0xFFEDE0DE),
    surface = Night6,
    onSurface = Color(0xFFEDE0DE),
    surfaceVariant = Ink20,
    surfaceContainerLow = Night12,
    surfaceContainer = Ink20,
)

private val AppShapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
)

@Composable
fun CampusEventTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}