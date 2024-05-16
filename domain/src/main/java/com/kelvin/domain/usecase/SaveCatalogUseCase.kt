package com.kelvin.domain.usecase

import com.kelvin.domain.data.CatalogEntity
import com.kelvin.domain.repository.CatalogRepository
import javax.inject.Inject

class SaveCatalogUseCase @Inject constructor(
    private val catalogRepository: CatalogRepository
) : BaseUseCase<CatalogEntity, Unit>() {
    override fun execute(params: CatalogEntity) {
        return catalogRepository.insertCatalog(params)
    }
}
