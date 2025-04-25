package com.apui.lokalassignment.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jobs")
data class JobEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String? = "",
    val place: String? = "",
    val salary: String? = "",
    val whatsapp_no: String? = "",
    val company_name: String? = "",
    val salary_type: String? = "",
    val experience: String? = "",
    val qualification: String? = "",
    val job_type: String? = "",
    val job_role: String? = "",
    val shift: String? = "",
    val gender: String? = "",
    val description: String? = ""
)
