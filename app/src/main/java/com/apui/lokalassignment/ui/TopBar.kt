package com.apui.lokalassignment.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.apui.lokalassignment.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry?.destination?.route

    TopAppBar(
        title = {
            when (currentScreen) {
                Screen.Jobs.route -> ShowTitle(Screen.Jobs.title)

                Screen.JobDetails.route -> ShowTitle(Screen.JobDetails.title)

                Screen.Bookmarks.route -> ShowTitle(Screen.Bookmarks.title)

                Screen.BookmarkedJobDetails.route -> ShowTitle(Screen.BookmarkedJobDetails.title)
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ShowTitle(title: String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title)
    }
}