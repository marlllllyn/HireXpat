package com.jer.hirexpat.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object JobList : Screen("job list")
    object Notif : Screen("notification")
    object Profile : Screen("profile")
    object DetailJob : Screen("home/{jobId}")
    object DetailJob2 : Screen("home/{jobId}")
    fun createRoute(jobId: Long) = "home/$jobId"

//    object LV: Screen("LV")
}
