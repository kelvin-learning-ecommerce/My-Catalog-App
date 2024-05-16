package com.kelvin.catalog.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kelvin.catalog.model.CatalogDaoModel

@Dao
interface RoomDao {
    @Query("SELECT * FROM catalogdaomodel")
    fun getAll(): List<CatalogDaoModel>

    @Insert
    fun insertCatalog(catalog: CatalogDaoModel)

    @Query("DELETE FROM catalogdaomodel WHERE id = :id")
    fun deleteById(id: Int)
}
