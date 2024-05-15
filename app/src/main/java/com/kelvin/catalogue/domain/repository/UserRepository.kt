package com.kelvin.catalogue.domain.repository

import com.kelvin.catalogue.data.datasource.ApiDataSource
import com.kelvin.catalogue.data.query.UserListQuery
import com.kelvin.catalogue.data.utils.Resource
import com.kelvin.catalogue.domain.data.CatalogEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface UserRepository {
    fun getUsers(
        params: UserListQuery
//        perPage: Int, since: Int, search: String?
    ): Flow<Resource<List<CatalogEntity>>>
}

class UserRepositoryImpl @Inject constructor(private val apiDataSource: ApiDataSource) :
    UserRepository {
    override fun getUsers(
        params: UserListQuery
//        perPage: Int,
//        since: Int,
//        search: String?
    ): Flow<Resource<List<CatalogEntity>>> = flow {
        emit(Resource.Loading())
        try {
            val res = apiDataSource.getUsersList(
                perPage = params.per_page,
                since = params.since,
                params.search
            )

            val data = res.map {
                it.mapToEntity()
            }

            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection."
                )
            )
        }
    }
}