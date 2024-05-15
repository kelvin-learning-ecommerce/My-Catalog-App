package com.kelvin.catalogue.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kelvin.catalogue.domain.data.CatalogEntity

@Entity
data class CatalogDaoModel(
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo("id") var id: Int,
    @ColumnInfo("name") var name: String,
    @ColumnInfo("avatar_url") var avatarUrl: String,
    @ColumnInfo("repos_url") var reposUrl: String,
) : DataMapper<CatalogEntity>() {
    override fun mapToEntity(): CatalogEntity =
        CatalogEntity(id, name, avatarUrl = avatarUrl, reposUrl = reposUrl)
}
