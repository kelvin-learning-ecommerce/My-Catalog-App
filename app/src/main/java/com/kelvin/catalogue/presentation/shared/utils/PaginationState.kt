package com.kelvin.catalogue.presentation.shared.utils

data class PaginationState(
    val isLoading: Boolean = false,
    val skip: Int = 1,
    val endReached: Boolean = false
)
