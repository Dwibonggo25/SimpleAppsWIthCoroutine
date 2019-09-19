package com.example.simpleappswithcoroutin.di.module

import com.example.simpleappswithcoroutin.ui.home.HomeFragment
import com.example.simpleappswithcoroutin.ui.listfood.ListDraftMenuFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesListDraftMenuFragment(): ListDraftMenuFragment

}