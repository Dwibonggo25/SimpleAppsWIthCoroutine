package com.example.simpleappswithcoroutin.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.simpleappswithcoroutin.db.entity.Foods

@Dao
interface FoodsDao {

    @Query ("SELECT * FROM foods order by name")
    fun getFoods() : LiveData<List<Foods>>

}