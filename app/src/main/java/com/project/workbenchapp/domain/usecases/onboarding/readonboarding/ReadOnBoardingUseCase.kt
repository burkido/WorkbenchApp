package com.project.workbenchapp.domain.usecases.onboarding.readonboarding

import com.project.workbenchapp.data.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val dataStoreRepository: DataStoreRepository,
) {

    operator fun invoke(): Flow<Boolean> {
        return dataStoreRepository.readOnBoardingState()
    }
}