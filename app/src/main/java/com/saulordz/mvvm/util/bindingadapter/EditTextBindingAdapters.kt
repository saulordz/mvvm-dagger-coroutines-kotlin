package com.saulordz.mvvm.util.bindingadapter

import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo.IME_ACTION_DONE
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("onSubmitListener")
fun bindOnSubmitListener(editText: EditText, listener: (String) -> Unit) {
  editText.setOnEditorActionListener { view, actionId, _ ->
    if (actionId == IME_ACTION_DONE) {
      listener(view.text.toString())
      true
    } else {
      false
    }
  }
}