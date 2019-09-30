package com.example.simpleappswithcoroutin.worker

import android.content.Context
import android.util.JsonReader
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.simpleappswithcoroutin.AppDatabase
import com.example.simpleappswithcoroutin.FOODS_DATA_FILENAME
import com.example.simpleappswithcoroutin.db.entity.Foods
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.coroutineScope
import java.lang.reflect.Type

class FoodsWorker (context: Context, workerParams: WorkerParameters) : CoroutineWorker (context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {

            applicationContext.assets.open(FOODS_DATA_FILENAME).use {
                JsonReader (it.reader()).use {jsonReader->
                    val foodType = object : TypeToken<List<Foods>> () {}.type
                    val foodsList : List <Foods> = Gson().fromJson(jsonReader, foodType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.plantDao().insertAll(plantList)
                }
            }
            Result.success()
        }catch (e: Exception){
            Result.failure()
        }
    }

    companion object {
        private val TAG = FoodsWorker::class.java.simpleName
    }
}