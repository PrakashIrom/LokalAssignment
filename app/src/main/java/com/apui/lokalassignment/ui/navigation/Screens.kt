package com.apui.lokalassignment.ui.navigation

sealed class Screen(val route: String = "", val title: String = "") {
    object Jobs : Screen(Screens.JOBS.name, "Jobs")
    object Bookmarks : Screen(Screens.BOOKMARKS.name, "Bookmarks")
    object JobDetails : Screen(Screens.JOB_DETAILS.name, "Job Details")
    object BookmarkedJobDetails :
        Screen(Screens.BOOKMARKED_JOB_DETAILS.name, "Bookmarked Job Details")
}

enum class Screens {
    JOBS,
    BOOKMARKS,
    JOB_DETAILS,
    BOOKMARKED_JOB_DETAILS
}
