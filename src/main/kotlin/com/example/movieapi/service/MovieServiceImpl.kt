package com.example.movieapi.service

import com.example.movieapi.controller.movie.payloads.MovieDetailsPayload
import com.example.movieapi.core.ResourceNotFoundException
import com.example.movieapi.repository.MovieRepository
import com.example.movieapi.utills.MovieMapper
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieService {
    override fun createMovie(movie: MovieDetailsPayload): MovieDetailsPayload {
        return movieMapper.fromEntity(movieRepository.save(movieMapper.toEntity(movie)))
    }

    override fun getAllMovies(): Iterable<MovieDetailsPayload> {
        return movieRepository.findAll().map { movieMapper.fromEntity(it) }
    }

    override fun getMovieById(id: Int): MovieDetailsPayload {
        val movie = movieRepository.findById(id).orElse(null) ?: throw ResourceNotFoundException("error.not-found", "No movie with this id")
        return movieMapper.fromEntity(movie);
    }

    override fun deleteMovieById(id: Int): Boolean {
        val movie = movieRepository.existsById(id);
        if (!movie) throw ResourceNotFoundException("error.not-found", "No movie with this id")
        movieRepository.deleteById(id)
        return true
    }

    override fun updateMovieById(id: Int, movie: MovieDetailsPayload): MovieDetailsPayload {
        val existingMovie = movieRepository.findById(id).orElse(null) ?: throw ResourceNotFoundException("error.not-found", "No movie with this id")
        val updatedMovie = movieRepository.save(existingMovie.copy(name=movie.name, rating=movie.rating));
        return movieMapper.fromEntity(updatedMovie)
    }
}