package com.example.messengerlab1

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

object ThemeManager {
    private val KEY_DARK = booleanPreferencesKey("dark_theme")

    fun isDarkThemeFlow(context: Context): Flow<Boolean> =
        context.dataStore.data.map { prefs -> prefs[KEY_DARK] ?: false }

    suspend fun setDarkTheme(context: Context, enabled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[KEY_DARK] = enabled
        }
    }
}