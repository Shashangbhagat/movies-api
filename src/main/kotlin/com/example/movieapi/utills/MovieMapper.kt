package com.example.movieapi.utills

import com.example.movieapi.controller.movie.payloads.MovieDetailsPayload
import com.example.movieapi.entity.Movie
import org.springframework.stereotype.Service

@Service
class MovieMapper: Mapper<MovieDetailsPayload, Movie> {
    override fun fromEntity(entity: Movie): MovieDetailsPayload {
        return MovieDetailsPayload(
            entity.id,
            entity.name,
            entity.rating
        )
    }

    override fun toEntity(domain: MovieDetailsPayload): Movie {
        return Movie(
            domain.id,
            domain.name,
            domain.rating
        )
    }
}