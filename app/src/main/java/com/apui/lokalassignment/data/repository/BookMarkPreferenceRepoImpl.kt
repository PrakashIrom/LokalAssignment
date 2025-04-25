package com.apui.lokalassignment.data.repository

import com.apui.lokalassignment.data.local.BookMarkPreference
import com.apui.lokalassignment.domain.repository.BookMarkPreferenceRepo
import kotlinx.coroutines.flow.Flow

class BookMarkPreferenceRepoImpl(
    private val bookMarkPreference: BookMarkPreference
) : BookMarkPreferenceRepo {

    override fun getBookmarkedJobIds(): Flow<Set<Int>> {
        return bookMarkPreference.getBookmarkedJobIds()
    }

    override suspend fun saveBookmarkedJobIds(ids: Set<Int>) {
        bookMarkPreference.saveBookmarkedJobIds(ids)
    }
}
