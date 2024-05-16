package com.kelvin.catalog.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kelvin.catalog.model.CatalogDaoModel

@Database(entities = [CatalogDaoModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catalogDao(): RoomDao
}
