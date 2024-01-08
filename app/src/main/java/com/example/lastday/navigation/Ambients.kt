package com.example.lastday.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

// Define a CompositionLocal for NavController
val navControllerAmbient = compositionLocalOf<NavHostController> { error("No NavController found!") }
