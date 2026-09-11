package com.priyabajaria.cs501.mobilitylens.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.mobilitylens.R

@Composable
fun DesignInputSection(
    designName: String,
    showError: Boolean,
    onDesignNameChange: (String) -> Unit,
    onApplyClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = designName,
            onValueChange = onDesignNameChange,
            label = {
                Text(
                    text = stringResource(R.string.design_field_label)
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.design_field_placeholder)
                )
            },
            supportingText = {
                if (showError) {
                    Text(
                        text = stringResource(R.string.blank_input_error)
                    )
                }
            },
            isError = showError,
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            onClick = onApplyClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.apply_lens_button)
            )
        }
    }
}