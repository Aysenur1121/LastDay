package com.example.lastday.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItem: List<NavItem> = listOf(

    NavItem(
        label = "Profile",
        icon = Icons.Default.Person,
        route = Screens.ProfileScreen.name
    ),
    NavItem(
        label = "Home",
        icon = Icons.Default.Home,
        route = Screens.HomeScreen.name
    ),
    NavItem(
        label = "Saved",
        icon = Icons.Default.List,  // saved için icon
        route = Screens.SavedScreen.name
    )

)