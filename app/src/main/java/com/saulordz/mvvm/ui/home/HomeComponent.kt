package com.saulordz.mvvm.ui.home

import com.saulordz.mvvm.di.ApplicationComponent
import com.saulordz.mvvm.di.Scopes
import dagger.Component
import javax.inject.Singleton

@Scopes.ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface HomeComponent {
  fun inject(homeActivity: HomeActivity)
}