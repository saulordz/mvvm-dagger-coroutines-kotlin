package com.saulordz.mvvm.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saulordz.mvvm.MvvmApplication
import com.saulordz.mvvm.di.ApplicationComponent

abstract class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    super.onCreate(savedInstanceState, persistentState)

    (application as MvvmApplication).applicationComponent?.let {
      injectDependencies(it)
    }
  }

  abstract fun injectDependencies(applicationComponent: ApplicationComponent)

  inline fun <VM : AndroidViewModel> viewModelFactory(crossinline f: () -> VM) =
    object : ViewModelProvider.Factory {
      override fun <T : ViewModel> create(aClass: Class<T>): T = f() as T
    }

}