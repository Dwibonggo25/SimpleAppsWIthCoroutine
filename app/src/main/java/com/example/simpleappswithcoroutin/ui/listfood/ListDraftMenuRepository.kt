package com.example.simpleappswithcoroutin.ui.listfood

import com.example.simpleappswithcoroutin.api.ApiService
import com.example.simpleappswithcoroutin.db.dao.FoodsDao
import com.example.simpleappswithcoroutin.db.dao.TestDao
import javax.inject.Inject

class ListDraftMenuRepository @Inject constructor(private val foodsDao: FoodsDao, private val apiservice: ApiService) {

    fun getFoodsList () = foodsDao.getFoods()
}