package com.example.lastday

sealed class Routes(val route: String) {
    object Login : Routes("Login")
}