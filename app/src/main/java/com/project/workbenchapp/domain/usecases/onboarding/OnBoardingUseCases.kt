package com.project.workbenchapp.domain.usecases.onboarding

import com.project.workbenchapp.domain.usecases.onboarding.readonboarding.ReadOnBoardingUseCase
import com.project.workbenchapp.domain.usecases.onboarding.saveonboarding.SaveOnBoardingUseCase

data class OnBoardingUseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)
