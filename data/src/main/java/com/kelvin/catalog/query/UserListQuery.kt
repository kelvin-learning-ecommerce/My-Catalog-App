package com.kelvin.catalog.query

data class UserListQuery(
    val per_page: Int = 10, var since: Int = 0, var search: String? = null
)
