package com.kelvin.domain.repository

import com.kelvin.catalog.datasource.CatalogDataSource
import com.kelvin.catalog.utils.Resource
import com.kelvin.domain.data.CatalogEntity
import com.kelvin.domain.mapper.mapToDaoModel
import com.kelvin.domain.mapper.mapToEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface CatalogRepository {
    fun getAll(): Flow<Resource<List<CatalogEntity>>>
    fun insertCatalog(catalog: CatalogEntity)
    fun deleteById(id: Int)
}

class CatalogRepositoryImpl @Inject constructor(private val catalogDataSource: CatalogDataSource) :
    CatalogRepository {
    override fun getAll(): Flow<Resource<List<CatalogEntity>>> = flow {
        emit(Resource.Loading())
        try {
            val res = catalogDataSource.getAll()

            val data = res.map {
                it.mapToEntity()
            }

            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection."
                )
            )
        }
    }

    override fun insertCatalog(catalog: CatalogEntity) {
        catalogDataSource.insertCatalog(catalog = catalog.mapToDaoModel())
    }

    override fun deleteById(id: Int) = catalogDataSource.deleteById(id)
}