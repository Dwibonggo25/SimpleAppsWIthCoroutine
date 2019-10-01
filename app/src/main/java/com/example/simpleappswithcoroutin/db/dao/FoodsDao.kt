package com.example.simpleappswithcoroutin.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simpleappswithcoroutin.db.entity.Foods

@Dao
interface FoodsDao {

    @Query ("SELECT * FROM foods order by name")
    fun getFoods() : LiveData<List<Foods>>

    @Insert (onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertAll (foods: List<Foods>)

    @Query ("SELECT * FROM foods WHERE id =:foodId")
    fun getFoodInfo (foodId: Long) : LiveData <Foods>

}