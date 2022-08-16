package com.project.workbenchapp.data.repository

import com.project.workbenchapp.domain.repository.DataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataStoreRepository @Inject constructor(
    private val dataStore: DataStore
) {

    suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.saveOnBoardingState(isCompleted = isCompleted)
    }

    fun readOnBoardingState() : Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}