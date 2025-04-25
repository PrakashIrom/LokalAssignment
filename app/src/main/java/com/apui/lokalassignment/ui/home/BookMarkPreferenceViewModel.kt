package com.apui.lokalassignment.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apui.lokalassignment.domain.repository.BookMarkPreferenceRepo
import kotlinx.coroutines.launch

class BookMarkPreferenceViewModel(
    private val bookMarkPreferenceRepo: BookMarkPreferenceRepo
) : ViewModel() {

    private var _bookmarkedJobIds by mutableStateOf(setOf<Int>())
    val bookmarkedJobIds: Set<Int>
        get() = _bookmarkedJobIds

    init {
        viewModelScope.launch {
            bookMarkPreferenceRepo.getBookmarkedJobIds().collect { ids ->
                _bookmarkedJobIds = ids
            }
        }
    }

    fun isBookMarked(jobId: Int): Boolean {
        return _bookmarkedJobIds.contains(jobId)
    }

    fun toggleBookmark(jobId: Int) {
        viewModelScope.launch {
            val updatedSet = _bookmarkedJobIds.toMutableSet().apply {
                if (contains(jobId)) remove(jobId) else add(jobId)
            }
            bookMarkPreferenceRepo.saveBookmarkedJobIds(updatedSet)
        }
    }
}
