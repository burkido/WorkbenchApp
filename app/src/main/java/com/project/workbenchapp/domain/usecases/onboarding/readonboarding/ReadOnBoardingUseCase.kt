package com.project.workbenchapp.domain.usecases.onboarding.readonboarding

import com.project.workbenchapp.data.repository.MasterRepository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val masterRepository: MasterRepository,
) {

    operator fun invoke(): Flow<Boolean> {
        return masterRepository.readOnBoardingState()
    }
}