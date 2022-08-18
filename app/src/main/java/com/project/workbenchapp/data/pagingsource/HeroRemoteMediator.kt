package com.project.workbenchapp.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.project.workbenchapp.data.local.WorkbenchDatabase
import com.project.workbenchapp.data.remote.WorkbenchApi
import com.project.workbenchapp.domain.model.Hero
import javax.inject.Inject

@ExperimentalPagingApi
class HeroRemoteMediator @Inject constructor(
    private val workbenchApi: WorkbenchApi,
    private val workbenchDatabase: WorkbenchDatabase    // workbenchDatabase will directly fetch the data from API. So we are not able to display it in UI directly.
) : RemoteMediator<Int, Hero>() {

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        TODO("Not yet implemented")
    }
}