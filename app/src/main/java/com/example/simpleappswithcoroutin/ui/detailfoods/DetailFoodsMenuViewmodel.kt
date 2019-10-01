package com.example.simpleappswithcoroutin.ui.detailfoods

import androidx.databinding.ObservableLong
import androidx.lifecycle.ViewModel
import com.example.simpleappswithcoroutin.ui.listfood.ListDraftMenuRepository
import javax.inject.Inject

class DetailFoodsMenuViewmodel @Inject constructor(private val repository: ListDraftMenuRepository) : ViewModel (){

    private val foodId = ObservableLong ()

    val foods = repository.getFoodInfo(foodId.get())

    fun setFoodId (id: Long) {
        foodId.set(id)
    }
}