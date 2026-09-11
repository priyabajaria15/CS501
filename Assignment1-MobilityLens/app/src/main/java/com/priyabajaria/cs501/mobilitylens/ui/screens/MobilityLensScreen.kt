package com.priyabajaria.cs501.mobilitylens.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.mobilitylens.R
import com.priyabajaria.cs501.mobilitylens.data.mobilityDimensions
import com.priyabajaria.cs501.mobilitylens.ui.components.AppHeader
import com.priyabajaria.cs501.mobilitylens.ui.components.DesignInputSection
import com.priyabajaria.cs501.mobilitylens.ui.components.DimensionCard
import com.priyabajaria.cs501.mobilitylens.ui.components.FeedbackCard
import com.priyabajaria.cs501.mobilitylens.ui.components.NavigationButtons
import com.priyabajaria.cs501.mobilitylens.ui.theme.MobilityLensTheme

@Composable
fun MobilityLensScreen(
    modifier: Modifier = Modifier
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    var designName by remember { mutableStateOf("") }
    var feedbackMessage by remember { mutableStateOf("") }
    var showInputError by remember { mutableStateOf(false) }

    val dimension = mobilityDimensions[selectedIndex]
    val dimensionName = stringResource(dimension.nameRes)

    val successMessage = stringResource(
        R.string.pairing_message,
        designName.trim(),
        dimensionName
    )

    fun clearFeedback() {
        feedbackMessage = ""
        showInputError = false
    }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = 20.dp,
                    vertical = 16.dp
                )
        ) {
            AppHeader()

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            DimensionCard(
                dimension = dimension,
                positionLabel = stringResource(
                    R.string.dimension_progress,
                    selectedIndex + 1,
                    mobilityDimensions.size
                )
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            NavigationButtons(
                previousEnabled = selectedIndex > 0,
                nextEnabled = selectedIndex < mobilityDimensions.lastIndex,
                onPreviousClick = {
                    selectedIndex--
                    clearFeedback()
                },
                onNextClick = {
                    selectedIndex++
                    clearFeedback()
                }
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            DesignInputSection(
                designName = designName,
                showError = showInputError,
                onDesignNameChange = { newName ->
                    designName = newName
                    clearFeedback()
                },
                onApplyClick = {
                    val cleanedName = designName.trim()

                    if (cleanedName.isEmpty()) {
                        showInputError = true
                        feedbackMessage = ""
                    } else {
                        showInputError = false
                        feedbackMessage = successMessage
                    }
                }
            )

            if (feedbackMessage.isNotEmpty()) {
                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                FeedbackCard(
                    message = feedbackMessage
                )
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "Mobility Lens Screen"
)
@Composable
private fun MobilityLensScreenPreview() {
    MobilityLensTheme {
        MobilityLensScreen()
    }
}