package com.example.customrecycler.api

import com.example.customrecycler.db.entity.Test
import com.example.customrecycler.model.SplashScreenResponse
import com.example.customrecycler.model.Todo
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET ("/todos/{id}")
    fun fetchALlData (@Path ( value = "id") todoId : Int) : Deferred<Todo>

}