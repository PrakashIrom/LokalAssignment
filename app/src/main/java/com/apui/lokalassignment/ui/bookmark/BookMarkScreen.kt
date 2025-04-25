package com.apui.lokalassignment.ui.bookmark

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.apui.lokalassignment.data.model.JobEntity
import com.apui.lokalassignment.ui.navigation.Screen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookMarkScreen(
    viewModel: BookMarkViewModel = koinViewModel(),
    navController: NavHostController,
) {
    val jobList = viewModel.jobList

    LazyColumn {
        items(jobList.size) { job ->
            JobItem(jobList[job], onClick = {
                viewModel.selectJob(jobList[job])
                navController.navigate(Screen.BookmarkedJobDetails.route)
            })
        }
    }

}

@Composable
fun JobItem(job: JobEntity, onClick: () -> Unit) {
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
                Text(job.place.toString())
                Text(job.salary.toString())
                Text(job.whatsapp_no.toString())
            }
        }
    }
}