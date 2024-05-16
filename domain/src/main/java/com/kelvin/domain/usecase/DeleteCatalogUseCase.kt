package com.kelvin.domain.usecase

import com.kelvin.domain.repository.CatalogRepository
import javax.inject.Inject

class DeleteCatalogUseCase @Inject constructor(
    private val catalogRepository: CatalogRepository
) : BaseUseCase<Int, Unit>() {
    override fun execute(params: Int) {
        return catalogRepository.deleteById(params)
    }
}
