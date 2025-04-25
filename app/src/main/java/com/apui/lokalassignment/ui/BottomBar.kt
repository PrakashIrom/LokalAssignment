package com.apui.lokalassignment.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.apui.lokalassignment.R
import com.apui.lokalassignment.ui.navigation.Screen

@Composable
fun BottomBar(navController: NavHostController) {
    val bottomBarScreens = listOf(Screen.Jobs.route, Screen.Bookmarks.route)
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    if (currentRoute !in bottomBarScreens) return

    val items: List<Screen> = listOf(Screen.Jobs, Screen.Bookmarks)

    NavigationBar(
        tonalElevation = 8.dp,
        modifier = Modifier.height(90.dp)
    ) {
        items.forEach { screen ->
            val isSelected = currentRoute == screen.route

            val iconRes = when (screen) {
                is Screen.Bookmarks -> if (isSelected) R.drawable.bookmark_black else R.drawable.bookmark_white
                else -> R.drawable.job
            }

            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = screen.title,
                        modifier = Modifier
                            .size(24.dp)
                            .padding( 2.dp)
                    )
                },
                label = { Text(screen.title) },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}