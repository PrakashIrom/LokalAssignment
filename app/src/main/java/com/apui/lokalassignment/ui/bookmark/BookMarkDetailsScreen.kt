package com.apui.lokalassignment.ui.bookmark

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookMarkDetailsScreen(viewModel: BookMarkViewModel = koinViewModel(), innerPadding: PaddingValues) {
    val bookmarkedJob = viewModel.selectedJob

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        bookmarkedJob?.title?.let { Text(it, style = MaterialTheme.typography.headlineMedium) }
        Text("Company: ${bookmarkedJob?.company_name}")
        Text("Location: ${bookmarkedJob?.place}")
        Text("Salary: ${bookmarkedJob?.salary}")
        Text("Experience: ${bookmarkedJob?.experience}")
        Text("Qualification: ${bookmarkedJob?.qualification}")
        Text("Job Type: ${bookmarkedJob?.job_type}")
        Text("Job Role: ${bookmarkedJob?.job_role}")
        Text("Shift: ${bookmarkedJob?.shift}")
        Text("Gender: ${bookmarkedJob?.gender}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Description:")
        Text(
            bookmarkedJob?.description ?: ""
        )
    }
}