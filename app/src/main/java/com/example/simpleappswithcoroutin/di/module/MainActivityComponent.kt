package com.example.simpleappswithcoroutin.di.module

import com.example.simpleappswithcoroutin.MainActivity
import dagger.android.AndroidInjector
import dagger.Subcomponent



@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}