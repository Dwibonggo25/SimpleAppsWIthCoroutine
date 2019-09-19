package com.example.simpleappswithcoroutin.ui.home

import androidx.lifecycle.*
import com.example.simpleappswithcoroutin.db.entity.Test
import com.example.simpleappswithcoroutin.repository.HomeRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewmodel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    private val _spinner = MutableLiveData<Boolean>()
    val spinner: LiveData<Boolean>
        get() = _spinner

    val userLiveData = liveData {
        val user = repository.fetchALlData(1)
        emit(user)
    }

//    fun getALlData (id: Int) {
//        viewModelScope.launch {
//            val data = withContext(Dispatchers.IO) {
//                repository.fetchALlData(id)
//            }
//            userLiveData.value = data.await()
//        }
//    }


}

