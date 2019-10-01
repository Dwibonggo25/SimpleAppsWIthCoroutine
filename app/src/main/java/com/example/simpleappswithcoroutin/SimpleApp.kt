package com.example.simpleappswithcoroutin

import android.app.Activity
import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager
import com.example.simpleappswithcoroutin.di.component.DaggerAppComponent
import com.example.simpleappswithcoroutin.di.worker.WorkerFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class SimpleApp : Application(), HasActivityInjector {

    @Inject
    lateinit var mWorkerFactory: WorkerFactory

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        WorkManager.initialize(this, Configuration.Builder().setWorkerFactory(mWorkerFactory).build())

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

}