package com.example.simpleappswithcoroutin.api

import com.example.simpleappswithcoroutin.model.Todo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET ("todos/{id}")
    suspend fun fetchALlData (@Path ( value = "id") todoId : Int) : Todo

}