package com.dev.daggermvvm.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.ElementType
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(
    val value: KClass<out ViewModel>
)
