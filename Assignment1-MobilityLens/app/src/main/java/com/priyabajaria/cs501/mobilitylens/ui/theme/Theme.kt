package com.priyabajaria.cs501.mobilitylens.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = EspressoBrown,
    onPrimary = Color.White,

    primaryContainer = SoftBeige,
    onPrimaryContainer = EspressoBrown,

    secondary = CocoaBrown,
    onSecondary = Color.White,

    secondaryContainer = CardBeige,
    onSecondaryContainer = EspressoBrown,

    tertiary = Terracotta,
    onTertiary = Color.White,

    tertiaryContainer = SuccessCream,
    onTertiaryContainer = SuccessBrown,

    background = WarmCream,
    onBackground = EspressoBrown,

    surface = WarmCream,
    onSurface = EspressoBrown,

    surfaceVariant = SoftBeige,
    onSurfaceVariant = MutedTaupe,

    outline = CocoaBrown
)

private val DarkColorScheme = darkColorScheme(
    primary = CardBeige,
    onPrimary = DarkEspresso,

    primaryContainer = CocoaBrown,
    onPrimaryContainer = LightCreamText,

    secondary = SoftBeige,
    onSecondary = DarkEspresso,

    tertiary = SoftTerracotta,
    onTertiary = DarkEspresso,

    tertiaryContainer = CocoaBrown,
    onTertiaryContainer = LightCreamText,

    background = DarkEspresso,
    onBackground = LightCreamText,

    surface = DarkEspresso,
    onSurface = LightCreamText,

    surfaceVariant = DarkCocoa,
    onSurfaceVariant = SoftBeige,

    outline = CardBeige
)

@Composable
fun MobilityLensTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) {
            DarkColorScheme
        } else {
            LightColorScheme
        },
        typography = MobilityLensTypography,
        content = content
    )
}