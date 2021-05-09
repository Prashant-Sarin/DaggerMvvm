package com.dev.daggermvvm.ui.auth

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.dev.daggermvvm.model.User
import com.dev.daggermvvm.network.auth.AuthApi
import io.reactivex.BackpressureStrategy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private var authApi: AuthApi) : ViewModel() {
    private val tag = "AuthViewModel"

    var user = MediatorLiveData<User>()
    var userId = ObservableField<String>()

    init {
        Log.d(tag, "init: AuthViewModel seems to be working!!")
    }

    /* fun fetchUser(id: Int){
         authApi.getUsers(id)
             .subscribeOn(Schedulers.io())
             .subscribe(object: Observer<User>{
                 override fun onSubscribe(d: Disposable) {
 //                    TODO("Not yet implemented")
                 }

                 override fun onNext(t: User) {
                     Log.d(tag, "onNext: user = $t")
                 }

                 override fun onError(e: Throwable) {
                     Log.e(tag, "onError: ${e.localizedMessage}" )
                 }

                 override fun onComplete() {
 //                    TODO("Not yet implemented")
                 }

             })
     }*/

    private fun fetchUser(id: Int) {
        val userResult = LiveDataReactiveStreams.fromPublisher(
            authApi.getUsers(id).subscribeOn(Schedulers.io())
                .toFlowable(BackpressureStrategy.LATEST)
        )

        user.addSource(userResult) {
            user.postValue(it)
            user.removeSource(userResult)
        }
    }

    fun onLoginClicked() {
        Log.d(tag, "onLoginClicked: userId = ${userId.get()}")
        userId.get()?.let {
            fetchUser(it.toInt())
        }
    }
}