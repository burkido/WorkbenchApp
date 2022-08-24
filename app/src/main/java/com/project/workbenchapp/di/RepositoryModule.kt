package com.project.workbenchapp.di

import android.content.Context
import com.project.workbenchapp.data.repository.DataStoreImpl
import com.project.workbenchapp.data.repository.MasterRepository
import com.project.workbenchapp.domain.repository.DataStore
import com.project.workbenchapp.domain.usecases.heroes.HeroesUseCases
import com.project.workbenchapp.domain.usecases.heroes.getallheroes.GetAllHeroesUseCase
import com.project.workbenchapp.domain.usecases.onboarding.OnBoardingUseCases
import com.project.workbenchapp.domain.usecases.onboarding.readonboarding.ReadOnBoardingUseCase
import com.project.workbenchapp.domain.usecases.onboarding.saveonboarding.SaveOnBoardingUseCase
import com.project.workbenchapp.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) : DataStore {
        return DataStoreImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideOnBoardingUseCases(masterRepository: MasterRepository) : OnBoardingUseCases {
        return OnBoardingUseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(masterRepository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(masterRepository)
        )
    }

    @Provides
    @Singleton
    fun provideHeroUseCases(masterRepository: MasterRepository) : HeroesUseCases {
        return HeroesUseCases(
            getAllHeroesUseCase = GetAllHeroesUseCase(masterRepository)
        )
    }

    @Singleton
    @Provides
    fun provideDispatchers(): DispatcherProvider = object : DispatcherProvider {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }

}