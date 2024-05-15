package com.kelvin.catalogue.core.di

import android.content.Context
import androidx.room.Room
import com.kelvin.catalogue.data.datasource.CatalogDataSource
import com.kelvin.catalogue.data.datasource.CatalogDataSourceImpl
import com.kelvin.catalogue.core.room.AppDatabase
import com.kelvin.catalogue.domain.repository.CatalogRepository
import com.kelvin.catalogue.domain.repository.CatalogRepositoryImpl
import com.kelvin.catalogue.domain.usecase.DeleteCatalogUseCase
import com.kelvin.catalogue.domain.usecase.FetchCatalogUseCase
import com.kelvin.catalogue.domain.usecase.SaveCatalogUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "catalog_app_db")
            .allowMainThreadQueries().build()
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object RoomRepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRoomDataSource(db: AppDatabase): CatalogDataSource {
        return CatalogDataSourceImpl(db)
    }

    @Provides
    @ViewModelScoped
    fun provideRoomRepository(datasource: CatalogDataSource): CatalogRepository {
        return CatalogRepositoryImpl(datasource)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteCatalogUseCase(repo: CatalogRepository): DeleteCatalogUseCase {
        return DeleteCatalogUseCase(repo)
    }

    @Provides
    @ViewModelScoped
    fun provideFCatalogUseCase(repo: CatalogRepository): FetchCatalogUseCase {
        return FetchCatalogUseCase(repo)
    }

    @Provides
    @ViewModelScoped
    fun provideSaveCatalogUseCase(repo: CatalogRepository): SaveCatalogUseCase {
        return SaveCatalogUseCase(repo)
    }
}
