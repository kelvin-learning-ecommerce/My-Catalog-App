package com.kelvin.catalog.dashboard.state

import com.kelvin.domain.data.CatalogEntity

data class DashboardState(
    val isLoading: Boolean = false,
    val data: List<CatalogEntity> = listOf(),
    val error: String? = ""
)
