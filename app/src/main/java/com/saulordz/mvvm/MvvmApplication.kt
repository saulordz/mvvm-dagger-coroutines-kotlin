package com.saulordz.mvvm

import android.app.Application
import com.saulordz.mvvm.di.ApplicationComponent
import com.saulordz.mvvm.di.DaggerApplicationComponent
import com.saulordz.mvvm.di.DataModule
import com.saulordz.mvvm.di.RepositoryModule

class MvvmApplication : Application() {

  var applicationComponent: ApplicationComponent? = null

  override fun onCreate() {
    super.onCreate()

    initDagger()
  }

  private fun initDagger() {
    applicationComponent = DaggerApplicationComponent.builder()
      .dataModule(DataModule())
      .repositoryModule(RepositoryModule())
      .build()
  }
}