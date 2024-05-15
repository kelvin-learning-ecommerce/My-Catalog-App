package com.kelvin.catalogue.data.datasource

import com.kelvin.catalogue.data.model.CatalogDaoModel
import com.kelvin.catalogue.core.room.AppDatabase
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
