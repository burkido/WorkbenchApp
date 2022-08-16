package com.project.workbenchapp.data.remote

import com.project.workbenchapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WorkbenchApi {

    @GET("/workbench/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/workbench/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse
}