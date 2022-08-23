package com.project.workbenchapp.data.repository

import androidx.paging.PagingData
import com.project.workbenchapp.domain.model.Hero
import com.project.workbenchapp.domain.repository.DataStore
import com.project.workbenchapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MasterRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dataStore: DataStore
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remoteDataSource.getAllHeroes()
    }

    suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.saveOnBoardingState(isCompleted = isCompleted)
    }

    fun readOnBoardingState() : Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}