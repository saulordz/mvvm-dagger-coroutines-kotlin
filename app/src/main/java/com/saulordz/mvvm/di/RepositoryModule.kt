package com.saulordz.mvvm.di

import com.saulordz.mvvm.data.remote.GoogleDictionaryService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryModule {

  @Singleton
  @Provides
  fun provideGoogleDictionaryService(retrofit: Retrofit): GoogleDictionaryService =
    retrofit.create(GoogleDictionaryService::class.java)

}