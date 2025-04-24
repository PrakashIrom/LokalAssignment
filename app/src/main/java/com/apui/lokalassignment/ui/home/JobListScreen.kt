package com.apui.lokalassignment.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.apui.lokalassignment.data.model.JobResponse
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun JobListScreen(
    jobListViewModel: JobListViewModel = koinViewModel(),
    innerPadding: PaddingValues
) {
    LaunchedEffect(Unit) {
        jobListViewModel.loadMorePage()
    }
    when (val response = jobListViewModel.jobState) {
        is JobStates.Error -> {
            Log.d("TAG", "JobListScreen: ${response.message}")
            Text(text = response.message)
        }

        is JobStates.Loading -> {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }

        is JobStates.Success -> {
            JobList(response, innerPadding)
        }
    }
}

@Composable
fun JobList(response: JobStates.Success, innerPadding: PaddingValues) {
    val jobList = response.data.results

    LazyColumn(modifier = Modifier.padding(innerPadding)) {
        items(jobList) { job ->
            JobItem(job)
        }
    }
}

@Composable
fun JobItem(job: JobResponse) {
    Card(modifier = Modifier.padding(10.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(job.title.toString())
            Text(job.primary_details?.Place.toString())
            Text(job.primary_details?.Salary.toString())
            Text(job.whatsapp_no.toString())
        }
    }
}