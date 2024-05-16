package com.kelvin.githubapiapp.popularlist

import com.kelvin.domain.data.CatalogEntity

val dummyPopularUiModel = listOf(
    CatalogEntity(
        id = 0,
        name = "mock 1",
        avatarUrl = "",
        reposUrl = "",
        isFavorite = true
    ),
    CatalogEntity(
        id = 1,
        name = "mock 2",
        avatarUrl = "",
        reposUrl = "",
        isFavorite = false
    )
)
