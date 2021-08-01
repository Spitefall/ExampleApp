package com.anri.exampleapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anri.exampleapp.di.annotations.ViewModelKey
import com.anri.exampleapp.di.factories.ViewModelFactory
import com.anri.exampleapp.ui.characters.ListCharactersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(ListCharactersViewModel::class)
    internal abstract fun listCharactersViewModel(listCharactersViewModel: ListCharactersViewModel): ViewModel

}