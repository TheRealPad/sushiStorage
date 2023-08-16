package com.example.mobile.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("favoriteSushi")
        private val FAVORITE_KEY = stringPreferencesKey("favorite_sushi")
    }

    val getFavorites: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[FAVORITE_KEY] ?: ""
    }

    suspend fun saveFavorites(token: String) {
        context.dataStore.edit { preferences ->
            preferences[FAVORITE_KEY] = token
        }
    }
}