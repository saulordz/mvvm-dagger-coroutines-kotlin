package com.saulordz.mvvm.ui.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.saulordz.mvvm.R
import com.saulordz.mvvm.base.BaseActivity
import com.saulordz.mvvm.data.repository.GoogleDictionaryRepository
import com.saulordz.mvvm.databinding.ActivityHomeBinding
import com.saulordz.mvvm.di.ApplicationComponent
import javax.inject.Inject

class HomeActivity : BaseActivity() {

  private lateinit var viewModel: HomeViewModel

  @Inject lateinit var googleDictionaryRepository: GoogleDictionaryRepository

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProviders.of(
      this,
      viewModelFactory { HomeViewModel(application, googleDictionaryRepository) }
    ).get(HomeViewModel::class.java)

    val homeBinding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    homeBinding.homeViewModel = viewModel
  }

  override fun injectDependencies(applicationComponent: ApplicationComponent) {
    DaggerHomeComponent.builder()
      .applicationComponent(applicationComponent)
      .build()
      .inject(this)
  }
}
