package com.example.movieapi.repository

import com.example.movieapi.entity.Movie
import org.springframework.data.repository.CrudRepository

interface MovieRepository: CrudRepository<Movie, Int>{}