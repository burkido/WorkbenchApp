package com.project.workbenchapp.domain.usecases.onboarding.saveonboarding

import com.project.workbenchapp.data.repository.DataStoreRepository

class SaveOnBoardingUseCase(
    private val dataStoreRepository: DataStoreRepository,
) {

    suspend operator fun invoke(isCompleted: Boolean) {
        dataStoreRepository.saveOnBoardingState(isCompleted = isCompleted)
    }
}