package com.example.customrecycler.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.customrecycler.di.ViewModelFactory
import com.example.customrecycler.di.ViewModelKey
import com.example.customrecycler.ui.home.HomeViewmodel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory : ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewmodel::class)
    internal abstract fun providesHomeViewmodel(viewModel : HomeViewmodel) : ViewModel

}