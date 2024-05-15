package com.kelvin.catalogue.data.datasource

import com.kelvin.catalogue.data.model.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("users/{q}")
    suspend fun getUsers(
        @Path("q") q: String? = null,
        @Query("per_page") page: Int? = 10,
        @Query("since") since: Int? = 0,
    ): Response<UserDto>

    @GET("users")
    suspend fun getUsers(
        @Query("per_page") page: Int? = 10,
        @Query("since") since: Int? = 0,
    ): Response<List<UserDto>>
}
