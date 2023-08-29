package com.example.movieapi.core

import java.lang.RuntimeException

class ResourceNotFoundException(
    message: String,
    val code: String?=null,
): RuntimeException(message)