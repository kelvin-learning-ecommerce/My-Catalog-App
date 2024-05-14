package com.kelvin.catalogue.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kelvin.catalogue.data.model.CatalogDaoModel

@Database(entities = [CatalogDaoModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catalogDao(): FavoriteDao
}
