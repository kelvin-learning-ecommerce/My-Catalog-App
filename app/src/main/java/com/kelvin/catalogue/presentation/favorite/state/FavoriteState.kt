package com.kelvin.catalogue.presentation.favorite.state

import com.kelvin.catalogue.domain.data.CatalogEntity

data class FavoriteState(
    val isLoading: Boolean = false,
    val data: List<CatalogEntity> = listOf(),
    val error: String? = null
)
