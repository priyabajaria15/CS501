package com.priyabajaria.cs501.campuseventexplorer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/** Accent (strong) and container (soft) colour for one category. */
@Immutable
data class CategoryPalette(val accent: Color, val container: Color, val onContainer: Color)

private val light = mapOf(
    "tech" to CategoryPalette(Color(0xFF1E5EFF), Color(0xFFDCE4FF), Color(0xFF00174F)),
    "career" to CategoryPalette(Color(0xFF7A4F00), Color(0xFFFFDDB0), Color(0xFF281800)),
    "music" to CategoryPalette(Color(0xFF8E24AA), Color(0xFFF6D9FF), Color(0xFF30004A)),
    "sports" to CategoryPalette(Color(0xFFC62828), Color(0xFFFFDAD6), Color(0xFF410002)),
    "wellness" to CategoryPalette(Color(0xFF2E7D32), Color(0xFFC8F0C3), Color(0xFF002204)),
    "culture" to CategoryPalette(Color(0xFFD84315), Color(0xFFFFDBCF), Color(0xFF390C00)),
    "arts" to CategoryPalette(Color(0xFF00796B), Color(0xFFB8F0E6), Color(0xFF00201C)),
)

private val dark = mapOf(
    "tech" to CategoryPalette(Color(0xFFB5C4FF), Color(0xFF003B9C), Color(0xFFDCE4FF)),
    "career" to CategoryPalette(Color(0xFFFFB950), Color(0xFF5C3B00), Color(0xFFFFDDB0)),
    "music" to CategoryPalette(Color(0xFFE9B3FF), Color(0xFF6A0E87), Color(0xFFF6D9FF)),
    "sports" to CategoryPalette(Color(0xFFFFB4AB), Color(0xFF93000A), Color(0xFFFFDAD6)),
    "wellness" to CategoryPalette(Color(0xFF9CD69A), Color(0xFF0F5216), Color(0xFFC8F0C3)),
    "culture" to CategoryPalette(Color(0xFFFFB59C), Color(0xFF822800), Color(0xFFFFDBCF)),
    "arts" to CategoryPalette(Color(0xFF8BD4C8), Color(0xFF005047), Color(0xFFB8F0E6)),
)

private val fallbackLight = CategoryPalette(Slate40, Slate90, Slate10)
private val fallbackDark = CategoryPalette(Slate80, Slate40, Slate90)

@Composable
fun categoryPalette(category: String): CategoryPalette {
    val key = category.lowercase()
    return if (isSystemInDarkTheme()) dark[key] ?: fallbackDark
    else light[key] ?: fallbackLight
}