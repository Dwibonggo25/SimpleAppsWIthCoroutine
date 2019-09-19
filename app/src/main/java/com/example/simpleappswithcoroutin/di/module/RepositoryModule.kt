package com.example.simpleappswithcoroutin.di.module

import com.example.simpleappswithcoroutin.AppDatabase
import com.example.simpleappswithcoroutin.api.ApiService
import com.example.simpleappswithcoroutin.db.dao.FoodsDao
import com.example.simpleappswithcoroutin.db.dao.TestDao
import com.example.simpleappswithcoroutin.repository.HomeRepository
import com.example.simpleappswithcoroutin.ui.listfood.ListDraftMenuRepository
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
    fun providesFoodsDao (db: AppDatabase) = db.foodsDao()

    @Provides
    @Singleton
    fun providesHomeRepository (testDao: TestDao, apiService: ApiService): HomeRepository = HomeRepository (testDao, apiService)

    @Provides
    @Singleton
    fun providesListDraftMenuRepository (foodsDao: FoodsDao, apiService: ApiService): ListDraftMenuRepository = ListDraftMenuRepository (foodsDao, apiService)


}