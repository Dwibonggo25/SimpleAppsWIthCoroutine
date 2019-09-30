package com.example.simpleappswithcoroutin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.simpleappswithcoroutin.db.dao.FoodsDao
import com.example.simpleappswithcoroutin.db.dao.TestDao
import com.example.simpleappswithcoroutin.db.entity.User
import com.example.simpleappswithcoroutin.db.dao.UserDao
import com.example.simpleappswithcoroutin.db.entity.Foods
import com.example.simpleappswithcoroutin.db.entity.Test

@Database(entities = [User::class, Test::class, Foods::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun testDao(): TestDao
    abstract fun foodsDao(): FoodsDao

}