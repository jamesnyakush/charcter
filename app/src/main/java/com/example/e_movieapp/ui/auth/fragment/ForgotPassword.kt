package com.example.e_movieapp.ui.auth.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.e_movieapp.R
import com.example.e_movieapp.databinding.ForgotPasswordFragmentBinding
import com.example.e_movieapp.ui.auth.viewmodel.AuthViewModel
import com.example.e_movieapp.ui.movie.activity.Movie
import com.example.e_movieapp.utils.Status
import com.example.e_movieapp.utils.toast
import com.roger.catloadinglibrary.CatLoadingView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPassword : Fragment(R.layout.forgot_password_fragment) {

    private lateinit var binding: ForgotPasswordFragmentBinding

    private val viewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = ForgotPasswordFragmentBinding.bind(view)

        binding.btnResetPassword.setOnClickListener {
            onForgotPassword()
        }

        observeLoginResult()
    }

    private fun observeLoginResult() {
        viewModel.resetResult.observe(viewLifecycleOwner, Observer { result ->
            if (result.status == Status.LOADING) {
                CatLoadingView().show(
                    childFragmentManager,
                    ""
                )
            }
            when (result.status) {
                Status.SUCCESS -> {
                    Toast.makeText(requireContext(), "Reset link sent to your email", Toast.LENGTH_LONG)
                        .show()
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

    private fun onForgotPassword() {
        val email = binding.etEmailReset.text.toString().trim()

        if (email.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter email id", Toast.LENGTH_LONG).show()
        }

        viewModel.reset(email)
    }
}