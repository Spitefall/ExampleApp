package com.anri.exampleapp.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.anri.exampleapp.ExampleApp
import com.anri.exampleapp.di.factories.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment(private val layoutRes: Int) : Fragment(layoutRes) {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        ExampleApp.component?.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    open fun initViewModel() {

    }
}