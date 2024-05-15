package com.kelvin.catalogue.presentation.dashboard.state

import com.kelvin.catalogue.domain.data.CatalogEntity

data class DashboardState(
    val isLoading: Boolean = false,
    val data: List<CatalogEntity> = listOf(),
    val error: String? = ""
)
