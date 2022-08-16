package com.project.workbenchapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.project.workbenchapp.data.remote.WorkbenchApi
import com.project.workbenchapp.util.Constants.Retrofit.BASE_URL
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
object NetworkModule {


    //the connection timeout is the timeout that is in making the initial connection. The read timeout is the timeout on waiting to read the data
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.MINUTES)
            .connectTimeout(15, TimeUnit.MINUTES)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient) : Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType = contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideWorkbenchApi(retrofit: Retrofit) : WorkbenchApi {
        return retrofit.create(WorkbenchApi::class.java)
    }
}