package com.example.demojetpack.utils

import com.example.demojetpack.models.ExampleJson2KtKotlin

sealed class NetworkResult<T>(val data: Any? = null, val message: String? = null) {

    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T : Any>(message: String?, data: T? = null) : NetworkResult<T>(data, message)
    class Loading<T> : NetworkResult<T>()

}