package com.kelvin.catalogue.data.model

abstract class DataMapper<T> {
    abstract fun mapToEntity(): T
}