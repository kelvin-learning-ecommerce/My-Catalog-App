package com.kelvin.domain.data

data class CatalogEntity(
    var id: Int,
    var name: String,
    var avatarUrl: String,
    var reposUrl: String,
    var isFavorite: Boolean = false,
)

fun List<CatalogEntity>.updateIsFavorite(id: Int, isFav: Boolean = true): List<CatalogEntity> =
    this.map { worker -> if (worker.id == id) worker.copy(isFavorite = isFav) else worker }
