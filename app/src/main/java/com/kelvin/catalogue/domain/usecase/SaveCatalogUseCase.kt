package com.kelvin.catalogue.domain.usecase

import com.kelvin.catalogue.data.model.CatalogDaoModel
import com.kelvin.catalogue.domain.data.CatalogEntity
import com.kelvin.catalogue.domain.repository.CatalogRepository
import com.kelvin.catalogue.domain.usecase.BaseUseCase
import javax.inject.Inject

class SaveCatalogUseCase @Inject constructor(
    private val catalogRepository: CatalogRepository
) : BaseUseCase<CatalogEntity, Unit>() {
    override fun execute(params: CatalogEntity) {
        return catalogRepository.insertCatalog(params)
    }
}
