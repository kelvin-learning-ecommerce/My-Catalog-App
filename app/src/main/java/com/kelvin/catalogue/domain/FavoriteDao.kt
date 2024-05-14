package com.kelvin.catalogue.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kelvin.catalogue.data.model.CatalogDaoModel

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM catalogdaomodel")
    fun getAll(): List<CatalogDaoModel>

    @Insert
    fun insertCatalog(catalog: CatalogDaoModel)

    @Query("DELETE FROM catalogdaomodel WHERE id = :id")
    fun deleteById(id: Int)
}
