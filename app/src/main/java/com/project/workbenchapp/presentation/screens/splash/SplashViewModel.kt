package com.project.workbenchapp.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.workbenchapp.domain.usecases.onboarding.OnBoardingUseCases
import com.project.workbenchapp.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class   SplashViewModel @Inject constructor(
    private val useCases: OnBoardingUseCases,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _isOnBoardingCompleted = MutableStateFlow(false)
    val isOnBoardingCompleted: StateFlow<Boolean> = _isOnBoardingCompleted

    init {
        viewModelScope.launch(dispatcherProvider.io) {
            _isOnBoardingCompleted.value =
                useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
        }
    }
}