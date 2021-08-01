package com.anri.exampleapp.di

import android.app.Application
import com.anri.exampleapp.ExampleApp
import com.anri.exampleapp.base.BaseFragment
import com.anri.exampleapp.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface MainComponent {

    fun inject(application: ExampleApp)
    fun inject(activity: BaseFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): MainComponent
    }

}
