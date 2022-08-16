package com.project.workbenchapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStore {

    suspend fun saveOnBoardingState(isCompleted: Boolean)

    fun readOnBoardingState() : Flow<Boolean>
}