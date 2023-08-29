package com.example.movieapi.controller.movie

import com.example.movieapi.controller.movie.payloads.MovieDetailsPayload
import com.example.movieapi.service.MovieService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

@RestController
@SpringBootApplication
class MovieController(
    val movieService: MovieService
) {
    @GetMapping("/movies")
    fun list(): ResponseEntity<Iterable<MovieDetailsPayload>> {
        return ResponseEntity(movieService.getAllMovies(), HttpStatus.OK)
    }

    @GetMapping("/movie/{id}")
    fun getMovie(
        @PathVariable id: Int,
    ): ResponseEntity<MovieDetailsPayload> {
        return ResponseEntity(movieService.getMovieById(id), HttpStatus.OK)
    }

    @PostMapping("/movie")
    fun postMovie(
        @RequestBody movie: MovieDetailsPayload
    ): ResponseEntity<MovieDetailsPayload> {
        return ResponseEntity(movieService.createMovie(movie), HttpStatus.CREATED);
    }

    @DeleteMapping("/movie/{id}")
    fun deleteMovie(
        @PathVariable id: Int,
    ): ResponseEntity<Boolean> {
        return ResponseEntity(movieService.deleteMovieById(id), HttpStatus.OK)
    }

    @PutMapping("/movie/{id}")
    fun updateMovie(
        @PathVariable id: Int,
        @RequestBody movie: MovieDetailsPayload
    ): ResponseEntity<MovieDetailsPayload> {
        return ResponseEntity(movieService.updateMovieById(id, movie), HttpStatus.OK)
    }
}
