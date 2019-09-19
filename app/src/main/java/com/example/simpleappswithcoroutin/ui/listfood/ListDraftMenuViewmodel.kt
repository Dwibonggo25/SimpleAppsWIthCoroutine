package com.example.simpleappswithcoroutin.ui.listfood

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.simpleappswithcoroutin.NO_GROW_ZONE
import com.example.simpleappswithcoroutin.db.entity.Foods
import javax.inject.Inject

class ListDraftMenuViewmodel @Inject constructor(private val repository: ListDraftMenuRepository) : ViewModel() {

    private val filterActive = MutableLiveData <Int> (NO_GROW_ZONE)

    val foods : LiveData<List<Foods>> = filterActive.switchMap {
        if (it == NO_GROW_ZONE){
            repository.getFoodsList()
        } else {
            repository.getFoodsList()
        }
    }

    fun setFilterActive (isActive : Int) {
        filterActive.value = isActive
    }

}