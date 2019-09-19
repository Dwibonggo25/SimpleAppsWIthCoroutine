package com.example.simpleappswithcoroutin.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simpleappswithcoroutin.db.entity.Test
import io.reactivex.Single

@Dao
interface TestDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert (test: List<Test>)

    @Query ("SELECT * From test")
    fun getAllData(): Single <List<Test>>
}