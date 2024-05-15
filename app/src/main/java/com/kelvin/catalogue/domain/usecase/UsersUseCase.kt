package com.kelvin.catalogue.domain.usecase

import com.kelvin.catalogue.data.query.UserListQuery
import com.kelvin.catalogue.data.utils.Resource
import com.kelvin.catalogue.domain.data.CatalogEntity
import com.kelvin.catalogue.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) : BaseUseCase<UserListQuery, Flow<Resource<List<CatalogEntity>>>>() {
    override fun execute(params: UserListQuery): Flow<Resource<List<CatalogEntity>>> {
        return userRepository.getUsers(params)
    }
}
