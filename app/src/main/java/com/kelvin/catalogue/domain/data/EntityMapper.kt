package com.kelvin.catalogue.domain.data

abstract class EntityMapper<T> {
    abstract fun mapToDto(): T
}