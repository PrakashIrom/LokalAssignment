package com.apui.lokalassignment.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apui.lokalassignment.ui.bookmark.BookMarkDetailsScreen
import com.apui.lokalassignment.ui.bookmark.BookMarkScreen
import com.apui.lokalassignment.ui.home.JobListScreen
import com.apui.lokalassignment.ui.jobdetail.JobDetailsScreen

@Composable
fun AppNavHost(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = Screen.Jobs.route) {
        composable(Screen.Jobs.route) {
            JobListScreen(innerPadding = innerPadding, navController = navController)
        }
        composable(Screen.JobDetails.route) {
            JobDetailsScreen(innerPadding = innerPadding)
        }
        composable(Screen.Bookmarks.route) {
            BookMarkScreen(navController = navController, innerPadding = innerPadding)
        }
        composable(Screen.BookmarkedJobDetails.route) {
            BookMarkDetailsScreen(innerPadding = innerPadding)
        }
    }
}