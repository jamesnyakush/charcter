package com.example.e_movieapp.ui.auth.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.e_movieapp.R
import com.example.e_movieapp.activities.SplashActivity
import com.example.e_movieapp.databinding.LoginFragmentBinding
import com.example.e_movieapp.ui.auth.viewmodel.AuthViewModel
import com.example.e_movieapp.ui.movie.activity.Movie
import com.example.e_movieapp.utils.Status
import com.example.e_movieapp.utils.toast
import com.roger.catloadinglibrary.CatLoadingView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Login : Fragment(R.layout.login_fragment), View.OnClickListener {

    private lateinit var binding: LoginFragmentBinding
    private val viewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = LoginFragmentBinding.bind(view)

        binding.btnLogin.setOnClickListener(this)
        binding.tvRegister.setOnClickListener(this)
        binding.tvForgotPassword.setOnClickListener(this)

        observeLoginResult()
    }
    private fun observeLoginResult() {
        viewModel.loginResult.observe(viewLifecycleOwner, Observer { result ->
            if (result.status == Status.LOADING) {
                CatLoadingView().show(
                    childFragmentManager,
                    ""
                )
            }
            when (result.status) {
                Status.SUCCESS -> {
                    Intent(context, Movie::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                    activity?.finish()
                }
                Status.ERROR -> {
                    if (result.exception != null) {
                        context?.toast(result!!.exception!!.message.toString())
                    } else {
                        context?.toast("Error has Occurred")
                    }
                }
                Status.LOADING -> {
                }
            }
        })
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                onLogin()
            }

            R.id.tvRegister -> {
                val action = LoginDirections.actionLoginToRegister()
                Navigation.findNavController(v).navigate(action)
            }

            R.id.tvForgotPassword -> {
                val action = LoginDirections.actionLoginToForgotPassword()
                Navigation.findNavController(v).navigate(action)
            }
        }

    }

    private fun onLogin() {
        val email = binding.edLoginEmail.text.toString().trim()
        val password = binding.etLoginPassword.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "Email and password are Required", Toast.LENGTH_SHORT)
                .show()
        }

        //viewmodel goes here
        viewModel.login(email, password)
    }
}