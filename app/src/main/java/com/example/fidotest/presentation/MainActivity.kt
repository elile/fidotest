package com.example.fidotest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.fidotest.presentation.ui.navigations.Navigation
import com.example.fidotest.ui.theme.FidotestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FidotestTheme {
                Navigation()
            }
        }
    }
}

