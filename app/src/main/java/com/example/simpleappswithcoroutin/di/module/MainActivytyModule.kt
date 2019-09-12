package com.example.customrecycler.di.module

import dagger.Provides
import com.example.customrecycler.MainActivity
import dagger.Module


@Module
class MainActivityModule {

    @Provides
    internal fun provideMainView(mainActivity: MainActivity)= mainActivity

}