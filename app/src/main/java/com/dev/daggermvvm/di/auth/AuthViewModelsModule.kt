package com.dev.daggermvvm.di.auth

import androidx.lifecycle.ViewModel
import com.dev.daggermvvm.di.ViewModelKey
import com.dev.daggermvvm.ui.auth.AuthViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel
}