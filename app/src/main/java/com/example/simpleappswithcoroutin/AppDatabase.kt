package com.example.customrecycler

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.customrecycler.db.dao.TestDao
import com.example.customrecycler.db.entity.User
import com.example.customrecycler.db.dao.UserDao
import com.example.customrecycler.db.entity.Test

@Database(entities = [User::class, Test::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun testDao(): TestDao

}