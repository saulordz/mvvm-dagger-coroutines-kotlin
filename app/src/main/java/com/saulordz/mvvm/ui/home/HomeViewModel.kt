package com.saulordz.mvvm.ui.home

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import com.saulordz.mvvm.BR
import com.saulordz.mvvm.base.BaseViewModel
import com.saulordz.mvvm.data.model.Word
import com.saulordz.mvvm.data.repository.GoogleDictionaryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class HomeViewModel(
  app: Application,
  private val googleDictionaryRepository: GoogleDictionaryRepository
) : BaseViewModel(app) {

  @Bindable
  var searchTerm: String = ""
    set(value) {
      field = value
      notifyPropertyChanged(BR.searchTerm)
    }
  val observableWord = ObservableField<Word>()

  val onSubmitListener: (String) -> Unit = { text ->
    searchTerm = text
    findWord()
  }

  fun resetSearchTerm() {
    searchTerm = "reset"
  }

  fun findWord() {
    CoroutineScope(Dispatchers.IO).async {
      try {
        val result = googleDictionaryRepository.getTest(searchTerm)
        onWordFound(result)
      } catch (exception: Exception) {
        onError(exception)
      }
    }
  }

  private fun onWordFound(word: Word?) {
    observableWord.set(word)
  }

  override fun onError(throwable: Throwable) {
    observableWord.set(Word("Error happened"))
    super.onError(throwable)
  }

}

