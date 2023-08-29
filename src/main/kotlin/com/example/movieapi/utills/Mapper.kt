package com.example.movieapi.utills

import com.example.movieapi.entity.Movie

interface Mapper<D, E> {
    fun fromEntity(entity: E): D
    fun toEntity(domain: D): E
}