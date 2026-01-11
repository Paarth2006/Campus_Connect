package com.paarth.campusconnect.ui.auth

import androidx.compose.runtime.mutableStateOf

object AuthState {
    val isLoggedIn = mutableStateOf(false)

    fun login(username: String, password: String): Boolean {
        return if (username == "developer" && password == "1010") {
            isLoggedIn.value = true
            true
        } else {
            false
        }
    }

    fun logout() {
        isLoggedIn.value = false
    }
}
