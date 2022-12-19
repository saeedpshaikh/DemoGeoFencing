package com.example.demojetpack.api


import com.example.demojetpack.models.ExampleJson2KtKotlin
import retrofit2.Response
import retrofit2.http.GET

interface UserAPI {
    @GET("/locations")
    suspend fun getLocation(): Response<List<ExampleJson2KtKotlin>>

}