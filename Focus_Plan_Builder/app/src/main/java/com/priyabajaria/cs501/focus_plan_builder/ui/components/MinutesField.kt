package com.priyabajaria.cs501.focus_plan_builder.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun MinutesField(
    minutesText: String,
    onMinutesChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val parsedMinutes: Int? = minutesText.toIntOrNull()

    val showMinutesError =
        minutesText.isNotEmpty() &&
                (parsedMinutes == null || parsedMinutes !in 10..180)

    OutlinedTextField(
        value = minutesText,
        onValueChange = onMinutesChange,
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(text = "Available minutes")
        },
        placeholder = {
            Text(text = "For example: 45")
        },
        supportingText = {
            Text(
                text = if (showMinutesError) {
                    "Please enter a number from 10 to 180."
                } else {
                    "Enter a duration from 10 through 180 minutes."
                }
            )
        },
        isError = showMinutesError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        singleLine = true,
        shape = RoundedCornerShape(18.dp),
        colors = focusFieldColors()
    )
}