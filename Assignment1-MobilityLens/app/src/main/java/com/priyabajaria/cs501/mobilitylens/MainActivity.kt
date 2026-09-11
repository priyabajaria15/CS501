package com.priyabajaria.cs501.mobilitylens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.priyabajaria.cs501.mobilitylens.ui.screens.MobilityLensScreen
import com.priyabajaria.cs501.mobilitylens.ui.theme.MobilityLensTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MobilityLensTheme {
                MobilityLensScreen()
            }
        }
    }
}