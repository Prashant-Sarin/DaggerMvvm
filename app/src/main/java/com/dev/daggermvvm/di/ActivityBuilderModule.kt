package com.dev.daggermvvm.di

import com.dev.daggermvvm.di.auth.AuthModule
import com.dev.daggermvvm.di.auth.AuthViewModelsModule
import com.dev.daggermvvm.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    // with annotation contributes / binds, it has to be in abstract class
    @ContributesAndroidInjector(
        modules = [AuthViewModelsModule::class, AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

}