package com.apui.lokalassignment.data.model

import kotlinx.serialization.Serializable

@Serializable
data class JobListResponse(
    val results: List<JobResponse>
)

@Serializable
data class JobResponse(
    val id: Int?=null,
    val title: String?=null,
    val type: Int?=null,
    val primary_details: PrimaryDetails?=null,
    val fee_details: FeeDetails?=null,
    val job_tags: List<JobTag>?=null,
    val job_type: Int?=null,
    val job_category_id: Int?=null,
    val qualification: Int?=null,
    val experience: Int?=null,
    val shift_timing: Int?=null,
    val job_role_id: Int?=null,
    val salary_max: Int? = null,
    val salary_min: Int? = null,
    val city_location: Int?=null,
    val locality: Int?=null,
    val premium_till: String? = null,
    val content: String? = null,
    val company_name: String? = null,
    val advertiser: Int? = null,
    val button_text: String? = null,
    val custom_link: String? = null,
    val amount: String? = null,
    val views: Int? = null,
    val shares: Int? = null,
    val fb_shares: Int? = null,
    val is_bookmarked: Boolean? = null,
    val is_applied: Boolean? = null,
    val is_owner: Boolean? = null,
    val updated_on: String? = null,
    val whatsapp_no: String? = null,
    val contact_preference: ContactPreference? = null,
    val created_on: String? = null,
    val is_premium: Boolean? = null,
    val creatives: List<Creative>? = emptyList(),
    val videos: List<String>? = emptyList(),
    val locations: List<Location>? = emptyList(),
    val tags: List<String>? = emptyList(),
    val contentV3: ContentV3? = null,
    val status: Int?=null,
    val expire_on: String?=null,
    val job_hours: String? = null,
    val openings_count: Int? = null,
    val job_role: String? = null,
    val other_details: String? = null,
    val job_category: String? = null,
    val num_applications: Int? = null,
    val enable_lead_collection: Boolean = false,
    val is_job_seeker_profile_mandatory: Boolean = false,
    val translated_content: TranslatedContent? = null,
    val job_location_slug: String? = null,
    val fees_text: String? = null,
    val question_bank_id: Int? = null,
    val screening_retry: Int? = null,
    val should_show_last_contacted: Boolean = false,
    val fees_charged: Int? = null
)

@Serializable
data class PrimaryDetails(
    val Place: String,
    val Salary: String,
    val Job_Type: String,
    val Experience: String,
    val Fees_Charged: String,
    val Qualification: String
)

@Serializable
data class FeeDetails(
    val V3: List<String>
)

@Serializable
data class JobTag(
    val value: String,
    val bg_color: String,
    val text_color: String
)

@Serializable
data class ContactPreference(
    val preference: Int,
    val whatsapp_link: String,
    val preferred_call_start_time: String,
    val preferred_call_end_time: String
)

@Serializable
data class Creative(
    val file: String? = null,
    val thumb_url: String? = null,
    val creative_type: Int? = null
)

@Serializable
data class Location(
    val id: Int,
    val locale: String,
    val state: Int
)

@Serializable
data class ContentV3(
    val V3: List<ContentField>
)

@Serializable
data class ContentField(
    val field_key: String,
    val field_name: String,
    val field_value: String
)

@Serializable
class TranslatedContent
