package com.kelvin.catalog.favorite.state

import com.kelvin.domain.data.CatalogEntity

data class FavoriteState(
    val isLoading: Boolean = false,
    val data: List<CatalogEntity> = listOf(),
    val error: String? = null
)
