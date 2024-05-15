package com.kelvin.catalogue.domain.usecase

import com.kelvin.catalogue.data.utils.Resource
import com.kelvin.catalogue.domain.data.CatalogEntity
import com.kelvin.catalogue.domain.repository.CatalogRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchCatalogUseCase @Inject constructor(
    private val catalogRepository: CatalogRepository
) : BaseUseCase<Unit, Flow<Resource<List<CatalogEntity>>>>() {
    override fun execute(params: Unit): Flow<Resource<List<CatalogEntity>>> {
        return catalogRepository.getAll()
    }
}
