package com.project.workbenchapp.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.workbenchapp.domain.usecases.onboarding.OnBoardingUseCases
import com.project.workbenchapp.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val useCases: OnBoardingUseCases,
    private val dispatcherProvider: DispatcherProvider,
) : ViewModel() {

    fun saveOnBoardingState(isCompleted: Boolean) {
        viewModelScope.launch(dispatcherProvider.io) {
            useCases.saveOnBoardingUseCase(isCompleted = isCompleted)
        }
    }
}