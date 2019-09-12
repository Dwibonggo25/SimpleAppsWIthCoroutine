package com.example.customrecycler.di.module

import com.example.customrecycler.AppDatabase
import com.example.customrecycler.api.ApiService
import com.example.customrecycler.db.dao.TestDao
import com.example.customrecycler.db.dao.UserDao
import com.example.customrecycler.repository.HomeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserDao (db: AppDatabase) = db.userDao()

    @Provides
    @Singleton
    fun providesTestDao (db: AppDatabase) = db.testDao()

    @Provides
    @Singleton
    fun providesHomeRepository (testDao: TestDao, apiService: ApiService): HomeRepository = HomeRepository (testDao, apiService)


}