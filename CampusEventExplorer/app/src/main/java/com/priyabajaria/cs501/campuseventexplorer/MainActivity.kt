package com.priyabajaria.cs501.campuseventexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.priyabajaria.cs501.campuseventexplorer.navigation.EventListRoute
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.CampusEventTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusEventTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // EventListRoute owns the search state. Navigation comes later.
                    EventListRoute(onEventSelected = {})
                }
            }
        }
    }
}