package com.project.workbenchapp.domain.usecases.onboarding.getallheroes

import androidx.paging.PagingData
import com.project.workbenchapp.data.repository.MasterRepository
import com.project.workbenchapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val masterRepository: MasterRepository
) {

    operator fun invoke(): Flow<PagingData<Hero>> {
        return masterRepository.getAllHeroes()
    }
}