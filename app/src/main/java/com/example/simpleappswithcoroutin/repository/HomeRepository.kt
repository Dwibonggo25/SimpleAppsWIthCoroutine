package com.example.simpleappswithcoroutin.repository

import com.example.simpleappswithcoroutin.api.ApiService
import com.example.simpleappswithcoroutin.db.dao.TestDao
import javax.inject.Inject

class HomeRepository @Inject constructor(private val testDao: TestDao, private val apiservice: ApiService) {
    suspend fun fetchALlData(id: Int) = apiservice.fetchALlData(id)

    sealed class State {
        object Loading: State()
        object Success : State ()
        class Error(val error: Throwable) : State()
    }
}


