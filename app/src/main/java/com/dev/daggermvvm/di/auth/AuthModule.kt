package com.dev.daggermvvm.di.auth

import com.dev.daggermvvm.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @Provides
    fun providesAuthApi(retrofit: Retrofit): AuthApi{
        return retrofit.create(AuthApi::class.java)
    }
}