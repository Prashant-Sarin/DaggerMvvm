package com.dev.daggermvvm.di

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.dev.daggermvvm.R
import com.dev.daggermvvm.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Any dependency needed on app level should be added here. such as retrofit builder/ db etc...
 */

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesRequestOptions(): RequestOptions{
        return RequestOptions().placeholder(R.drawable.ic_error).error(R.drawable.ic_error)
    }

    @Singleton
    @Provides
    fun providesGlideInstance(application: Application,requestOptions: RequestOptions):RequestManager{
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }
}