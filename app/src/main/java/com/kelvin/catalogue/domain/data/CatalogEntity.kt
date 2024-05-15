package com.kelvin.catalogue.domain.data

import com.kelvin.catalogue.data.model.CatalogDaoModel
import com.kelvin.catalogue.data.model.DataMapper

data class CatalogEntity(
    var id: Int,
    var name: String,
    var avatarUrl: String,
    var reposUrl: String,
    var isFavorite: Boolean = false,
) : EntityMapper<CatalogDaoModel>() {
    override fun mapToDto(): CatalogDaoModel =
        CatalogDaoModel(id = id, name = name, avatarUrl = avatarUrl, reposUrl = reposUrl)
}

fun List<CatalogEntity>.updateIsFavorite(id: Int, isFav: Boolean): List<CatalogEntity> =
    this.map { worker -> if (worker.id == id) worker.copy(isFavorite = isFav) else worker }