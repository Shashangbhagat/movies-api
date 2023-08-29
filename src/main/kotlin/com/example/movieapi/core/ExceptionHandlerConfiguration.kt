package com.example.movieapi.core

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerConfiguration {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleResourceNotFoundException(
        exception: ResourceNotFoundException
    ): ApiError{
        return ApiError(exception.code, exception.message)
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun handleInternalServerError(): ApiError{
        return ApiError("code.internal-server-error", "Something went wrong")
    }
}