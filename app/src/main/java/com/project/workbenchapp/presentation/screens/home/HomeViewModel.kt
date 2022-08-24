package com.project.workbenchapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.project.workbenchapp.domain.usecases.heroes.HeroesUseCases
import com.project.workbenchapp.domain.usecases.heroes.getallheroes.GetAllHeroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    heroesUseCases: HeroesUseCases
): ViewModel() {

    val getAllHeroes = heroesUseCases.getAllHeroesUseCase()
}