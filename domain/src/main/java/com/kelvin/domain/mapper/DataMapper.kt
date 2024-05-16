package com.kelvin.domain.mapper

import com.kelvin.catalog.model.CatalogDaoModel
import com.kelvin.catalog.model.UserDto
import com.kelvin.domain.data.CatalogEntity

fun CatalogDaoModel.mapToEntity(): CatalogEntity =
    CatalogEntity(id, name, avatarUrl = avatarUrl, reposUrl = reposUrl)

fun UserDto.mapToEntity(): CatalogEntity =
    CatalogEntity(id ?: 0, login ?: "", avatarUrl = avatarUrl ?: "", reposUrl = reposUrl ?: "")

fun CatalogEntity.mapToDaoModel(): CatalogDaoModel =
    CatalogDaoModel(id = id, name = name, avatarUrl = avatarUrl, reposUrl = reposUrl)