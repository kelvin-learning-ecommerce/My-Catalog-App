package com.kelvin.domain.usecase

import com.kelvin.catalog.query.UserListQuery
import com.kelvin.catalog.utils.Resource
import com.kelvin.domain.data.CatalogEntity
import com.kelvin.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) : BaseUseCase<UserListQuery, Flow<Resource<List<CatalogEntity>>>>() {
    override fun execute(params: UserListQuery): Flow<Resource<List<CatalogEntity>>> {
        return userRepository.getUsers(params)
    }
}
