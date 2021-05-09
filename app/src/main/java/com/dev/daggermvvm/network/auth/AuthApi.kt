package com.dev.daggermvvm.network.auth

import com.dev.daggermvvm.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("users/{id}")
    fun getUsers(@Path("id") id: Int): Observable<User>
}