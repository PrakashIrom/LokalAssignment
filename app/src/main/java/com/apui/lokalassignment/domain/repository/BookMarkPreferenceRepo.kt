package com.apui.lokalassignment.domain.repository

import kotlinx.coroutines.flow.Flow

interface BookMarkPreferenceRepo {
    fun getBookmarkedJobIds(): Flow<Set<Int>>
    suspend fun saveBookmarkedJobIds(ids: Set<Int>)
}
