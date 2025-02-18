package com.atgentertainment.interviewproject.network

import com.atgentertainment.interviewproject.network.repository.Repository
import com.atgentertainment.interviewproject.network.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): RetrofitApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RetrofitApi::class.java)
    }

    @Provides
    fun provideRepository(retrofitApi: RetrofitApi): Repository {
        return RepositoryImpl(retrofitApi)
    }
}