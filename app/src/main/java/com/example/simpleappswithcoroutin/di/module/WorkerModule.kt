package com.example.simpleappswithcoroutin.di.module

import com.example.simpleappswithcoroutin.di.WorkerKey
import com.example.simpleappswithcoroutin.di.worker.ChildWorkerFactory
import com.example.simpleappswithcoroutin.worker.FoodsWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(FoodsWorker::class)
    internal abstract fun bindTopupDraftReminderWorker(worker : FoodsWorker.Factory) : ChildWorkerFactory
}