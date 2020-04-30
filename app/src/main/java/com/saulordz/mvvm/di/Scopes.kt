package com.saulordz.mvvm.di

import javax.inject.Scope

object Scopes {
  @Scope
  @Target(AnnotationTarget.TYPE)
  @Retention(AnnotationRetention.RUNTIME)
  annotation class AppScope

  @Scope
  @Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
  @Retention(AnnotationRetention.RUNTIME)
  annotation class ActivityScope
}