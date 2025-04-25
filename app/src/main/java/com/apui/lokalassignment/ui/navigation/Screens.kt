package com.apui.lokalassignment.ui.navigation

sealed class Screen(val route: String = "", val title: String = "") {
    object Jobs : Screen(Screens.JOBS.name, "Jobs")
    object Bookmarks : Screen(Screens.BOOKMARKS.name, "Bookmarks")
    object JobDetails : Screen(Screens.JOB_DETAILS.name)
}

enum class Screens {
    JOBS,
    BOOKMARKS,
    JOB_DETAILS
}
