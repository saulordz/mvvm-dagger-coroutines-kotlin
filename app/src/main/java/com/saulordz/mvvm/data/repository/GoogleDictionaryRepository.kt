package com.saulordz.mvvm.data.repository

import com.saulordz.mvvm.data.model.Word
import com.saulordz.mvvm.data.remote.GoogleDictionaryService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleDictionaryRepository @Inject constructor(
  private val googleDictionaryService: GoogleDictionaryService
) {

  suspend fun getTest(searchTerm: String): Word? {
    val response = googleDictionaryService.getWord(searchTerm)
    val body = response.body()
    return if (response.isSuccessful && body != null) {
      body.firstOrNull()
    } else {
      throw IllegalStateException("Error fetching details")
    }
  }

  internal fun <T> T?.orDefault(defaultValue: T) = this ?: defaultValue
}