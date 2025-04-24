package com.apui.lokalassignment.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apui.lokalassignment.ui.home.JobListScreen
import com.apui.lokalassignment.ui.jobdetail.JobDetailsScreen

@Composable
fun AppNavHost(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = Screens.HOME.name) {
        composable(Screens.HOME.name) {
            JobListScreen(innerPadding = innerPadding, navController = navController)
        }
        composable(Screens.JOB_DETAILS_SCREEN.name) {
            JobDetailsScreen()
        }
    }
}