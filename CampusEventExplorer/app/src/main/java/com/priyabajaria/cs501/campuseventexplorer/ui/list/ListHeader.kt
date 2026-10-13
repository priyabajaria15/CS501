package com.priyabajaria.cs501.campuseventexplorer.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.R

/** Coloured header holding the title, result count and the search field. */
@Composable
fun ListHeader(
    shown: Int,
    total: Int,
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = headerColors()

    Column(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp))
            .background(colors.brush)
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.list_title),
            style = MaterialTheme.typography.headlineMedium,
            color = colors.content
        )
        Text(
            text = stringResource(R.string.list_subtitle, shown, total),
            style = MaterialTheme.typography.bodyMedium,
            color = colors.content.copy(alpha = 0.8f)
        )
        Spacer(Modifier.height(16.dp))
        SearchField(query = query, onQueryChange = onQueryChange)
    }
}

private data class HeaderColors(val brush: Brush, val content: Color)

/** Bright scarlet gradient in light mode, deep red in dark mode. */
@Composable
private fun headerColors(): HeaderColors {
    val scheme = MaterialTheme.colorScheme
    val isDark = scheme.background.luminance() < 0.5f
    val base = if (isDark) scheme.primaryContainer else scheme.primary
    val content = if (isDark) scheme.onPrimaryContainer else scheme.onPrimary
    return HeaderColors(
        brush = Brush.linearGradient(listOf(base, lerp(base, Color.Black, 0.28f))),
        content = content
    )
}