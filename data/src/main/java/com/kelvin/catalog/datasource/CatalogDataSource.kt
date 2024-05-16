package com.kelvin.catalog.datasource

import com.kelvin.catalog.room.AppDatabase
import com.kelvin.catalog.model.CatalogDaoModel
import javax.inject.Inject

interface CatalogDataSource {
    fun getAll(): List<CatalogDaoModel>
    fun insertCatalog(catalog: CatalogDaoModel)
    fun deleteById(id: Int)
}

class CatalogDataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) :
    CatalogDataSource {
    override fun getAll(): List<CatalogDaoModel> = appDatabase.catalogDao().getAll()

    override fun insertCatalog(catalog: CatalogDaoModel) {
        return appDatabase.catalogDao().insertCatalog(catalog = catalog)
    }

    override fun deleteById(id: Int) {
        return appDatabase.catalogDao().deleteById(id)
    }
}
