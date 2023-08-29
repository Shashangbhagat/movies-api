package com.example.movieapi.service

import com.example.movieapi.controller.movie.payloads.MovieDetailsPayload
import org.springframework.stereotype.Service

@Service
interface MovieService {

    fun createMovie(movieDTO: MovieDetailsPayload): MovieDetailsPayload
    fun getAllMovies(): Iterable<MovieDetailsPayload>
    fun getMovieById(id: Int): MovieDetailsPayload
    fun deleteMovieById(id: Int): Boolean
    fun updateMovieById(id: Int, movie: MovieDetailsPayload): MovieDetailsPayload
}