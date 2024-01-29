package com.jer.hirexpat.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.jer.hirexpat.ui.home.HireXpatApp
import com.jer.hirexpat.ui.joblist.JobViewModel
import com.jer.hirexpat.ui.theme.HireXpatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        val vm = JobViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            HireXpatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HireXpatApp()
                }
            }
        }
    }
}

