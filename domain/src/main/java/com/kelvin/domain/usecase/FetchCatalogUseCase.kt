package com.kelvin.domain.usecase

import com.kelvin.catalog.utils.Resource
import com.kelvin.domain.data.CatalogEntity
import com.kelvin.domain.repository.CatalogRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchCatalogUseCase @Inject constructor(
    private val catalogRepository: CatalogRepository
) : BaseUseCase<Unit, Flow<Resource<List<CatalogEntity>>>>() {
    override fun execute(params: Unit): Flow<Resource<List<CatalogEntity>>> {
        return catalogRepository.getAll()
    }
}
