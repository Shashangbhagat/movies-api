package com.example.movieapi.controller.movie.payloads

import com.example.movieapi.entity.Movie

data class MovieDetailsPayload(
    val id: Int? = -1,
    val name: String,
    val rating: Double,
) {
    companion object {
        fun create(movie: Movie): MovieDetailsPayload {
            return MovieDetailsPayload(movie.id, movie.name, movie.rating)
        }
    }
}
