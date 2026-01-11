package com.paarth.campusconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import com.paarth.campusconnect.ui.auth.AuthState
import com.paarth.campusconnect.ui.auth.LoginScreen
import com.paarth.campusconnect.ui.navigation.MainScreen
import com.paarth.campusconnect.ui.CampusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            CampusTheme {
                val isLoggedIn by AuthState.isLoggedIn

                if (isLoggedIn) {
                    MainScreen()
                } else {
                    LoginScreen()
                }
            }
        }
    }
}
