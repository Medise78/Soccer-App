package com.medise.soccerscoreapp.di

import android.content.Context
import com.medise.soccerscoreapp.data.ApiService
import com.medise.soccerscoreapp.data.repository.SoccerRepository
import com.medise.soccerscoreapp.domain.repository.SoccerRepositoryImpl
import com.medise.soccerscoreapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttp(
        @ApplicationContext context: Context
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val cacheControl = CacheControl.Builder()
            .maxAge(10 , TimeUnit.MINUTES)
            .build()

        return OkHttpClient().newBuilder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Cache-Control",cacheControl.toString())
                    .tag("chain")
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .cache(
                Cache(
                    directory = File(context.cacheDir, "http_cache"),
                    maxSize = 50L * 1024L * 1024L
                )
            )
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideSoccerRepository(apiService: ApiService): SoccerRepository {
        return SoccerRepositoryImpl(apiService)
    }
}