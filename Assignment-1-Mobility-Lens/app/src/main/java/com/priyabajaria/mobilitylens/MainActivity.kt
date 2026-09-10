package com.priyabajaria.mobilitylens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.priyabajaria.mobilitylens.ui.theme.MobilityLensTheme

// Cream minimalist color palette
private val CreamBackground = Color(0xFFF8F4EC)
private val CardCream = Color(0xFFFFFCF6)
private val DarkBrown = Color(0xFF3E352E)
private val WarmBrown = Color(0xFF765F4B)
private val SoftBeige = Color(0xFFE7DDD0)
private val AccentBrown = Color(0xFF8A6D52)
private val SuccessBackground = Color(0xFFE8EFE4)
private val SuccessText = Color(0xFF496044)
private val ErrorBackground = Color(0xFFFFE8E5)
private val ErrorText = Color(0xFF9C3D35)

data class MobilityDimension(
    @StringRes val titleResource: Int,
    @StringRes val descriptionResource: Int,
    @StringRes val implicationResource: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MobilityLensTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CreamBackground
                ) {
                    MobilityLensApp()
                }
            }
        }
    }
}

@Composable
fun MobilityLensApp(modifier: Modifier = Modifier) {
    val dimensions = listOf(
        MobilityDimension(
            R.string.dimension_input_title,
            R.string.dimension_input_description,
            R.string.dimension_input_implication
        ),
        MobilityDimension(
            R.string.dimension_screen_title,
            R.string.dimension_screen_description,
            R.string.dimension_screen_implication
        ),
        MobilityDimension(
            R.string.dimension_lifecycle_title,
            R.string.dimension_lifecycle_description,
            R.string.dimension_lifecycle_implication
        ),
        MobilityDimension(
            R.string.dimension_context_title,
            R.string.dimension_context_description,
            R.string.dimension_context_implication
        ),
        MobilityDimension(
            R.string.dimension_usage_title,
            R.string.dimension_usage_description,
            R.string.dimension_usage_implication
        ),
        MobilityDimension(
            R.string.dimension_security_title,
            R.string.dimension_security_description,
            R.string.dimension_security_implication
        )
    )

    // Normal remember is intentionally used for the rotation observation.
    var selectedDimensionIndex by remember { mutableIntStateOf(0) }
    var applicationName by remember { mutableStateOf("") }
    var validationAttempted by remember { mutableStateOf(false) }

    val currentDimension = dimensions[selectedDimensionIndex]
    val inputIsBlank = applicationName.isBlank()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = CreamBackground
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(CreamBackground)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            Text(
                text = stringResource(R.string.app_title),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = DarkBrown
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.app_introduction),
                style = MaterialTheme.typography.bodyLarge,
                color = WarmBrown
            )

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "MOBILITY DIMENSION",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = AccentBrown
                )

                Text(
                    text = stringResource(
                        R.string.dimension_progress,
                        selectedDimensionIndex + 1,
                        dimensions.size
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = WarmBrown
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
                progress = {
                    (selectedDimensionIndex + 1).toFloat() / dimensions.size
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = AccentBrown,
                trackColor = SoftBeige
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardCream
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = SoftBeige
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(22.dp)
                ) {
                    Text(
                        text = stringResource(currentDimension.titleResource),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = DarkBrown
                    )

                    Spacer(modifier = Modifier.height(22.dp))

                    Text(
                        text = stringResource(R.string.constraint_label)
                            .uppercase(),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = AccentBrown
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = stringResource(
                            currentDimension.descriptionResource
                        ),
                        style = MaterialTheme.typography.bodyLarge,
                        color = DarkBrown
                    )

                    Spacer(modifier = Modifier.height(22.dp))

                    Text(
                        text = stringResource(
                            R.string.developer_implication_label
                        ).uppercase(),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = AccentBrown
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = stringResource(
                            currentDimension.implicationResource
                        ),
                        style = MaterialTheme.typography.bodyLarge,
                        color = DarkBrown
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        selectedDimensionIndex--
                        validationAttempted = false
                    },
                    enabled = selectedDimensionIndex > 0,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(1.dp, AccentBrown),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = AccentBrown
                    )
                ) {
                    Text(
                        text = stringResource(R.string.previous_button),
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Button(
                    onClick = {
                        selectedDimensionIndex++
                        validationAttempted = false
                    },
                    enabled = selectedDimensionIndex < dimensions.lastIndex,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AccentBrown,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = stringResource(R.string.next_button),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "CHECK YOUR DESIGN",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = AccentBrown
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = applicationName,
                onValueChange = {
                    applicationName = it
                    validationAttempted = false
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(stringResource(R.string.application_name_label))
                },
                placeholder = {
                    Text(
                        text = stringResource(
                            R.string.application_name_placeholder
                        )
                    )
                },
                singleLine = true,
                isError = validationAttempted && inputIsBlank,
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AccentBrown,
                    focusedLabelColor = AccentBrown,
                    cursorColor = AccentBrown,
                    unfocusedBorderColor = SoftBeige,
                    focusedContainerColor = CardCream,
                    unfocusedContainerColor = CardCream
                )
            )

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = {
                    validationAttempted = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBrown,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = stringResource(R.string.check_design_button),
                    fontWeight = FontWeight.Bold
                )
            }

            if (validationAttempted) {
                Spacer(modifier = Modifier.height(14.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (inputIsBlank) {
                            ErrorBackground
                        } else {
                            SuccessBackground
                        }
                    )
                ) {
                    Text(
                        text = if (inputIsBlank) {
                            stringResource(R.string.blank_input_message)
                        } else {
                            stringResource(
                                R.string.success_message,
                                applicationName.trim(),
                                stringResource(
                                    currentDimension.titleResource
                                )
                            )
                        },
                        modifier = Modifier.padding(16.dp),
                        color = if (inputIsBlank) {
                            ErrorText
                        } else {
                            SuccessText
                        },
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MobilityLensAppPreview() {
    MobilityLensTheme {
        MobilityLensApp()
    }
}