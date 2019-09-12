package com.example.customrecycler.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.customrecycler.api.ApiService
import com.example.customrecycler.db.dao.TestDao
import com.example.customrecycler.model.Todo
import javax.inject.Inject
import javax.security.auth.callback.Callback

class HomeRepository @Inject constructor(
    private val testDao: TestDao,
    private val apiservice: ApiService
) {
    suspend fun fetchALlData(id: Int) = apiservice.fetchALlData(id)
}

