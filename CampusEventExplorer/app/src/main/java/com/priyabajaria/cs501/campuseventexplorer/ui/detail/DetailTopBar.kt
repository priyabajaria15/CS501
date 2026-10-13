package com.priyabajaria.cs501.campuseventexplorer.ui.detail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.priyabajaria.cs501.campuseventexplorer.R
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.CategoryPalette

/** App bar with the Up button, tinted by category (plain surface when there's no event). */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(palette: CategoryPalette?, onBack: () -> Unit) {
    val contentColor = palette?.onContainer ?: MaterialTheme.colorScheme.onSurface

    TopAppBar(
        title = { Text(stringResource(R.string.event_details)) },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigate_up)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = palette?.container ?: MaterialTheme.colorScheme.surface,
            titleContentColor = contentColor,
            navigationIconContentColor = contentColor
        )
    )
}