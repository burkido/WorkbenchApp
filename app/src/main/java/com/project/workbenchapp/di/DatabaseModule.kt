package com.project.workbenchapp.di

import android.content.Context
import androidx.room.Room
import com.project.workbenchapp.data.local.WorkbenchDatabase
import com.project.workbenchapp.util.Constants.Database.WORKBENCH_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        WorkbenchDatabase::class.java,
        WORKBENCH_DATABASE
    ).build()

}