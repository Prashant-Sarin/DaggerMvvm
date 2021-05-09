package com.dev.daggermvvm.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.dev.daggermvvm.R
import com.dev.daggermvvm.databinding.ActivityAuthBinding
import com.dev.daggermvvm.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    private val tag = "AuthActivity"

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var requestManager: RequestManager

    private var viewModel: AuthViewModel? = null

    private var binding: ActivityAuthBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)
        binding?.viewModel = viewModel
        binding?.executePendingBindings()
        setupObservers()
        setLogo()
    }

    private fun setupObservers() {
        viewModel?.user?.observe(this, {
            Log.d(tag, "setupObservers: user = $it")
        })
    }

    private fun setLogo() {
        // getting glide instance and loading image in imageview
        requestManager.load(R.drawable.ic_injection).into(findViewById(R.id.login_logo))
    }
}