package com.project.workbenchapp.domain.usecases.onboarding.saveonboarding

import com.project.workbenchapp.data.repository.MasterRepository

class SaveOnBoardingUseCase(
    private val masterRepository: MasterRepository,
) {

    suspend operator fun invoke(isCompleted: Boolean) {
        masterRepository.saveOnBoardingState(isCompleted = isCompleted)
    }
}