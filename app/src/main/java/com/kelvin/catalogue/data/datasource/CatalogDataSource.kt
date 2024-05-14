package com.kelvin.catalogue.data.datasource

import com.kelvin.catalogue.data.model.CatalogDaoModel
import com.kelvin.catalogue.data.utils.Resource
import com.kelvin.catalogue.domain.AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface CatalogDataSource {
//    fun getAll(): Flow<Resource<List<CatalogDaoModel>>>
    fun getAll(): List<CatalogDaoModel>
    fun insertCatalog(catalog: CatalogDaoModel)
    fun deleteById(id: Int)
}

class CatalogDataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) :
    CatalogDataSource {
//    override fun getAll(): Flow<Resource<List<CatalogDaoModel>>> =
    override fun getAll(): List<CatalogDaoModel> =appDatabase.catalogDao().getAll()
//        flow {
//            emit(Resource.Loading())
//            try {
//                val data = appDatabase.catalogDao().getAll()

//                emit(Resource.Success(data))
//            } catch (e: HttpException) {
//                emit(
//                    Resource.Error(
//                        message = "Oops, something went wrong!"
//                    )
//                )
//            } catch (e: IOException) {
//                emit(
//                    Resource.Error(
//                        message = "Couldn't reach server, check your internet connection."
//                    )
//                )
//            }
//        }

    override fun insertCatalog(catalog: CatalogDaoModel) {
        return appDatabase.catalogDao().insertCatalog(catalog = catalog)
    }

    override fun deleteById(id: Int) {
        return appDatabase.catalogDao().deleteById(id)
    }
}
