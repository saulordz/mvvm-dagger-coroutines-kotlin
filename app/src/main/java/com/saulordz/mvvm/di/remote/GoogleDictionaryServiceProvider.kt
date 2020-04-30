package com.saulordz.mvvm.di.remote

import com.saulordz.mvvm.data.remote.GoogleDictionaryService
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Provider

class GoogleDictionaryServiceProvider @Inject constructor(
  private val retrofit: Retrofit
) : Provider<GoogleDictionaryService> {

  override fun get(): GoogleDictionaryService =
    retrofit.create(GoogleDictionaryService::class.java)

}