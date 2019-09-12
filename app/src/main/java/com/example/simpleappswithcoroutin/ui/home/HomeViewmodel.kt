package com.example.customrecycler.ui.home

import androidx.lifecycle.*
import com.example.customrecycler.db.entity.Test
import com.example.customrecycler.model.SplashScreenResponse
import com.example.customrecycler.model.Todo
import com.example.customrecycler.repository.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomeViewmodel @Inject constructor(private val repository: HomeRepository) :
    ViewModel() {

    private var mCompositeDisposable = CompositeDisposable()

    private val _isData = MutableLiveData<List<Test>>()
    val isData: LiveData<List<Test>>
        get() = _isData

    val userLiveData = liveData {
        val user =  repository.fetchALlData(1)
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

