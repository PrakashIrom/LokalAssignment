package com.apui.lokalassignment.ui.jobdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.apui.lokalassignment.ui.home.JobListViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun JobDetailsScreen(viewModel: JobListViewModel = koinViewModel(), innerPadding: androidx.compose.foundation.layout.PaddingValues) {
    val jobResponse = viewModel.selectedJob
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        jobResponse?.title?.let { Text(it, style = MaterialTheme.typography.headlineMedium) }
        Text("Company: ${jobResponse?.company_name}")
        Text("Location: ${jobResponse?.primary_details?.Place}")
        Text("Salary: ${jobResponse?.primary_details?.Salary}")
        Text("Experience: ${jobResponse?.primary_details?.Experience}")
        Text("Qualification: ${jobResponse?.primary_details?.Qualification}")
        Text("Job Type: ${jobResponse?.primary_details?.Job_Type}")
        Text("Job Role: ${jobResponse?.job_role}")
        Text("Shift: ${jobResponse?.contentV3?.V3?.find { it.field_key == "Shift timing" }?.field_value}")
        Text("Gender: ${jobResponse?.contentV3?.V3?.find { it.field_key == "Gender" }?.field_value}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Description:")
        Text(
            jobResponse?.contentV3?.V3?.find { it.field_key == "Other details" }?.field_value ?: ""
        )
    }
}