package com.apui.lokalassignment.ui.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.apui.lokalassignment.R
import com.apui.lokalassignment.data.model.JobEntity
import com.apui.lokalassignment.data.model.JobResponse
import com.apui.lokalassignment.ui.bookmark.BookMarkViewModel
import com.apui.lokalassignment.ui.navigation.Screen
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import java.util.UUID

@Composable
fun JobListScreen(
    jobListViewModel: JobListViewModel = koinViewModel(),
    innerPadding: PaddingValues,
    navController: NavHostController
) {

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
            JobList(response, innerPadding, navController, jobListViewModel)
        }
    }
}

@Composable
fun JobList(
    response: JobStates.Success,
    innerPadding: PaddingValues,
    navController: NavHostController,
    jobListViewModel: JobListViewModel
) {
    val jobList = response.data.results

    LazyColumn(modifier = Modifier.padding(innerPadding)) {
        items(jobList) { job ->
            JobItem(job, onClick = {
                jobListViewModel.selectJob(job)
                navController.navigate(Screen.JobDetails.route)
            })
        }
    }
}

@Composable
fun JobItem(
    job: JobResponse,
    onClick: () -> Unit,
    bookMarkPreferenceViewModel: BookMarkPreferenceViewModel = koinViewModel(),
    bookMarkViewModel: BookMarkViewModel = koinViewModel()
) {
    val isBookMarked = remember {
        derivedStateOf { job.id?.let { bookMarkPreferenceViewModel.isBookMarked(it) } ?: false }
    }
    val coroutineScope = rememberCoroutineScope()

    Card(modifier = Modifier
        .padding(10.dp)
        .clickable {
            onClick()
        }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(job.title.toString())
                Text(job.primary_details?.Place.toString())
                Text(job.primary_details?.Salary.toString())
                Text(job.whatsapp_no.toString())
            }

            Icon(
                painter = painterResource(
                    if (isBookMarked.value) R.drawable.bookmark_black else R.drawable.bookmark_white
                ),
                contentDescription = "Bookmark",
                modifier = Modifier
                    .size(24.dp)
                    .padding(start = 8.dp)
                    .clickable {
                        coroutineScope.launch {
                            val jobEntity = JobEntity(
                                id = (job.id ?: UUID
                                    .randomUUID()
                                    .toString()).toString(),
                                title = job.title.toString(),
                                place = job.primary_details?.Place.toString(),
                                salary = job.primary_details?.Salary.toString(),
                                whatsapp_no = job.whatsapp_no.toString(),
                                company_name = job.company_name.toString(),
                                experience = job.primary_details?.Experience.toString(),
                                qualification = job.primary_details?.Qualification.toString(),
                                job_type = job.primary_details?.Job_Type.toString(),
                                job_role = job.job_role.toString(),
                                shift = job.contentV3?.V3?.find { it.field_key == "Shift timing" }?.field_value.toString(),
                                gender = job.contentV3?.V3?.find { it.field_key == "Gender" }?.field_value,
                                description = job.contentV3?.V3?.find { it.field_key == "Other details" }?.field_value
                            )

                            if (isBookMarked.value) {
                                bookMarkViewModel.deleteJob(jobEntity)
                            } else {
                                bookMarkViewModel.insertJob(jobEntity)
                            }
                        }
                        job.id?.let { bookMarkPreferenceViewModel.toggleBookmark(it) }
                    }
            )
        }

    }
}