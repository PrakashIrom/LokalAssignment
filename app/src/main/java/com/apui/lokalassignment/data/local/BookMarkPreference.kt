package com.apui.lokalassignment.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.bookMarkDataStore: DataStore<Preferences> by preferencesDataStore(name = "bookmark")

class BookMarkPreference(private val context: Context) {

    private val BOOKMARKED_JOBS_KEY = stringSetPreferencesKey("bookmarked_jobs")

    fun getBookmarkedJobIds(): Flow<Set<Int>> {
        return context.bookMarkDataStore.data.map { prefs ->
            prefs[BOOKMARKED_JOBS_KEY]?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
        }
    }

    suspend fun saveBookmarkedJobIds(ids: Set<Int>) {
        context.bookMarkDataStore.edit { prefs ->
            prefs[BOOKMARKED_JOBS_KEY] = ids.map { it.toString() }.toSet()
        }
    }
}

