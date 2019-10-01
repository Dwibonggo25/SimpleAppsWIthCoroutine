package com.example.simpleappswithcoroutin.di.component

import com.example.simpleappswithcoroutin.di.module.WorkerModule
import dagger.Component

@Component (
    modules = [
        WorkerModule::class
    ]
)
interface WorkerComponent {

}