package com.kelvin.catalog.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatalogDaoModel(
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo("id") var id: Int,
    @ColumnInfo("name") var name: String,
    @ColumnInfo("avatar_url") var avatarUrl: String,
    @ColumnInfo("repos_url") var reposUrl: String,
)
