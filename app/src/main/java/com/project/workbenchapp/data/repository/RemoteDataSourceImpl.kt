package com.project.workbenchapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.project.workbenchapp.data.local.WorkbenchDatabase
import com.project.workbenchapp.data.pagingsource.HeroRemoteMediator
import com.project.workbenchapp.data.remote.WorkbenchApi
import com.project.workbenchapp.domain.model.Hero
import com.project.workbenchapp.domain.repository.RemoteDataSource
import com.project.workbenchapp.util.Constants.Pages.ITEMS_COUNT_PER_PAGE
import kotlinx.coroutines.flow.Flow


@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val workbenchApi: WorkbenchApi,
    private val workbenchDatabase: WorkbenchDatabase,
) : RemoteDataSource {

    private val heroDao = workbenchDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {

        val pagingSourceFactory = { heroDao.getAllHeroes() }

        return Pager(
            config = PagingConfig(pageSize = ITEMS_COUNT_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                workbenchApi = workbenchApi,
                workbenchDatabase = workbenchDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}