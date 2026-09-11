package com.priyabajaria.cs501.mobilitylens.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.mobilitylens.R

@Composable
fun NavigationButtons(
    previousEnabled: Boolean,
    nextEnabled: Boolean,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedButton(
            onClick = onPreviousClick,
            enabled = previousEnabled,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.previous_button)
            )
        }

        OutlinedButton(
            onClick = onNextClick,
            enabled = nextEnabled,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.next_button)
            )
        }
    }
}