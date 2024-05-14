package com.kelvin.catalogue.core.di

import android.content.Context
import androidx.room.Room
import com.kelvin.catalogue.data.datasource.CatalogDataSource
import com.kelvin.catalogue.data.datasource.CatalogDataSourceImpl
import com.kelvin.catalogue.domain.AppDatabase
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
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "github_kelvin_app_db")
            .allowMainThreadQueries().build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDbProductRepository(db: AppDatabase): CatalogDataSource {
        return CatalogDataSourceImpl(db)
    }
}
