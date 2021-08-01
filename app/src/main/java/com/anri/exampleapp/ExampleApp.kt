package com.anri.exampleapp

import android.app.Application
import com.anri.exampleapp.di.DaggerMainComponent
import com.anri.exampleapp.di.MainComponent

class ExampleApp: Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerMainComponent.builder().application(this).build()
        component?.inject(this)
    }

    companion object {
        var component: MainComponent? = null
    }
}