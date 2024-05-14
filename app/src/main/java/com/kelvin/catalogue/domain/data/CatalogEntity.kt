package com.kelvin.catalogue.domain.data

import com.kelvin.catalogue.data.model.CatalogDaoModel
import com.kelvin.catalogue.data.model.DataMapper

data class CatalogEntity(
    var id: Int,
    var name: String,
) : EntityMapper<CatalogDaoModel>() {
    override fun mapToDto(): CatalogDaoModel = CatalogDaoModel(id = id, name = name)
}
