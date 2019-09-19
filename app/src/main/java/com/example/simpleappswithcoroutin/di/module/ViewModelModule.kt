package com.example.simpleappswithcoroutin.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simpleappswithcoroutin.di.ViewModelFactory
import com.example.simpleappswithcoroutin.di.ViewModelKey
import com.example.simpleappswithcoroutin.ui.home.HomeViewmodel
import com.example.simpleappswithcoroutin.ui.listfood.ListDraftMenuViewmodel
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

    @Binds
    @IntoMap
    @ViewModelKey(ListDraftMenuViewmodel::class)
    internal abstract fun providesListDraftMenuViewmodel(viewModel : ListDraftMenuViewmodel) : ViewModel

}