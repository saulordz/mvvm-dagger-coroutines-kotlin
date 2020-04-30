package com.saulordz.mvvm.di

import com.saulordz.mvvm.data.repository.GoogleDictionaryRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(DataModule::class, RepositoryModule::class))
interface ApplicationComponent {
  fun googleDictionaryRepository(): GoogleDictionaryRepository
}