package com.saulordz.mvvm.base

import android.app.Application
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(
  app: Application
) : AndroidViewModel(app), Observable {

  @delegate:Transient
  private val mCallBacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

  override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
    mCallBacks.add(callback)
  }

  override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
    mCallBacks.remove(callback)
  }

  fun notifyChange() {
    mCallBacks.notifyChange(this, 0)
  }

  fun notifyChange(viewId: Int) {
    mCallBacks.notifyChange(this, viewId)
  }

  open fun notifyPropertyChanged(fieldId: Int) {
    synchronized(this) {
      if (mCallBacks == null) {
        return
      }
    }
    mCallBacks.notifyCallbacks(this, fieldId, null)
  }

  open fun onError(throwable: Throwable) {
    throw throwable
  }
}