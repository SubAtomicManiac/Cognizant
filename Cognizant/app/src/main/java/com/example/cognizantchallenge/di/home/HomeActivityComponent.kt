package com.example.cognizantchallenge.di.home

import com.example.cognizantchallenge.ui.HomeActivity
import com.example.cognizantchallenge.di.app.appComponent
import dagger.Component

@HomeActivityScope
@Component(modules = [HomeActivityModule::class],dependencies = [appComponent::class])
interface HomeActivityComponent {
    fun inject(homeActivity: HomeActivity)

}