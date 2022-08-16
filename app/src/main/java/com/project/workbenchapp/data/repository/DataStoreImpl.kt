package com.project.workbenchapp.data.repository

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.project.workbenchapp.domain.repository.DataStore
import com.project.workbenchapp.util.Constants.Preferences.PREFERENCES_KEY
import com.project.workbenchapp.util.Constants.Preferences.PREFERENCES_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: androidx.datastore.core.DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreImpl(context: Context) : DataStore {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = PREFERENCES_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = isCompleted
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException)
                    emit(emptyPreferences())
                else
                    throw exception
            }
            .map { preferences ->
                val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: false
                onBoardingState
            }
    }
}