package com.saulordz.mvvm.data.remote

import com.saulordz.mvvm.data.model.Word
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GoogleDictionaryService {

  @GET("api/v1/entries/en/{searchTerm}")
  suspend fun getWord(@Path(value = "searchTerm") searchTerm: String): Response<List<Word>>
}