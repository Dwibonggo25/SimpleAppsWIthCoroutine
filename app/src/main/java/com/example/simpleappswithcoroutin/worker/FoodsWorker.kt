package com.example.simpleappswithcoroutin.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.example.simpleappswithcoroutin.FOODS_DATA_FILENAME
import com.example.simpleappswithcoroutin.db.entity.Foods
import com.example.simpleappswithcoroutin.di.worker.ChildWorkerFactory
import com.example.simpleappswithcoroutin.ui.listfood.ListDraftMenuRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Provider

class FoodsWorker (context: Context, workerParams: WorkerParameters, val repository: ListDraftMenuRepository) : CoroutineWorker (context, workerParams) {

    companion object {
        private val TAG = FoodsWorker::class.java.simpleName
    }

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(FOODS_DATA_FILENAME).use {
                JsonReader (it.reader()).use { jsonReader->
                    val foodType = object : TypeToken<List<Foods>> () {}.type
                    val foodsList : List <Foods> = Gson().fromJson(jsonReader, foodType)
                    repository.insertAllFoods(foodsList)
                }
            }
            Result.success()
        }catch (e: Exception){
            Result.failure()
        }
    }

    class Factory @Inject constructor(val repository: Provider<ListDraftMenuRepository>) : ChildWorkerFactory{
        override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
            return FoodsWorker(appContext, params, repository.get())
        }
    }

}