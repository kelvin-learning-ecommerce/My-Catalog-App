package com.kelvin.catalogue.core.di

import android.content.Context
import androidx.room.Room
import com.kelvin.catalogue.core.room.AppDatabase
import com.kelvin.catalogue.data.datasource.ApiDataSource
import com.kelvin.catalogue.data.datasource.ApiDataSourceImpl
import com.kelvin.catalogue.data.datasource.ApiService
import com.kelvin.catalogue.domain.repository.UserRepository
import com.kelvin.catalogue.domain.repository.UserRepositoryImpl
import com.kelvin.catalogue.domain.usecase.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.github.com/"

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {



    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client =

            OkHttpClient.Builder().apply {
                addInterceptor(
                    Interceptor { chain ->
                        val builder = chain.request().newBuilder()
                        builder.header(
                            "Authorization",
                            "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"
                        )

                        return@Interceptor chain.proceed(builder.build())
                    }
                )
                addInterceptor(interceptor)
            }.build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object DaggerHiltModule {


//    @Provides
//    @ViewModelScoped
//    fun provideRetrofit(): Retrofit {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        val client =
//
//            OkHttpClient.Builder().apply {
//                addInterceptor(
//                    Interceptor { chain ->
//                        val builder = chain.request().newBuilder()
//                        builder.header(
//                            "Authorization",
//                            "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"
//                        )
//
//                        return@Interceptor chain.proceed(builder.build())
//                    }
//                )
//                addInterceptor(interceptor)
//            }.build()
//
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

    @Provides
    @ViewModelScoped
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideApiDataSource(apiService: ApiService): ApiDataSource {
        return ApiDataSourceImpl(apiService)
    }

    @Provides
    @ViewModelScoped
    fun provideUserRepository(apiDataSource: ApiDataSource): UserRepository {
        return UserRepositoryImpl(apiDataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideUsersUseCase(userRepository: UserRepository): UsersUseCase {
        return UsersUseCase(userRepository)
    }
}
