package com.example.simpleappswithcoroutin.di.module

import dagger.Provides
import com.example.simpleappswithcoroutin.MainActivity
import dagger.Module


@Module
class MainActivityModule {

    @Provides
    internal fun provideMainView(mainActivity: MainActivity)= mainActivity

}