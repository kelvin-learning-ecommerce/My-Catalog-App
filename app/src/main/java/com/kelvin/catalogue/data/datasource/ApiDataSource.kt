package com.kelvin.catalogue.data.datasource

import com.kelvin.catalogue.data.model.UserDto
import javax.inject.Inject

interface ApiDataSource {
    suspend fun getUsersList(perPage: Int, since: Int, search: String?): List<UserDto>
}
class ApiDataSourceImpl @Inject constructor(private val api: ApiService): ApiDataSource {
    override suspend fun getUsersList(
        perPage: Int,
        since: Int,
        search: String?
    ): List<UserDto> {
        val result = mutableListOf<UserDto>()
        if (search == null) {
            val res = api.getUsers(
                page = perPage,
                since = since,
            )
            res.body()?.let { result.addAll(it) }

        } else {
            val res = api.getUsers(
                page = perPage,
                since = since,
                q = search
            )
            res.body()?.let { result.add(it) }
        }

        return result.toList()
    }
}