package com.example.e_movieapp.ui.auth.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.e_movieapp.R
import com.example.e_movieapp.activities.SplashActivity
import com.example.e_movieapp.databinding.RegisterFragmentBinding
import com.example.e_movieapp.ui.auth.viewmodel.AuthViewModel
import com.example.e_movieapp.utils.Status
import com.example.e_movieapp.utils.toast
import com.roger.catloadinglibrary.CatLoadingView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Register : Fragment(R.layout.register_fragment), View.OnClickListener {

    private lateinit var binding: RegisterFragmentBinding
    private val viewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = RegisterFragmentBinding.bind(view)

        binding.btnSignup.setOnClickListener(this)

        observeSignUpResult()
    }

    private fun observeSignUpResult() {
        viewModel.signUpResult.observe(viewLifecycleOwner, Observer { result ->
            if (result.status == Status.LOADING) {
                CatLoadingView().show(
                    childFragmentManager,
                    ""
                )
            }
            when (result.status) {
                Status.SUCCESS -> {
                    Intent(context, SplashActivity::class.java).also {
                        it.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
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
            R.id.btnSignup -> {
                onSignup()
            }
        }
    }

    private fun onSignup() {
        val email = binding.edEmail.text.toString().trim()
        val password = binding.edPassword.text.toString().trim()
        val confirmPassword = binding.etConfirmpassword.text.toString().trim()

        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(requireContext(), "All Fields Required", Toast.LENGTH_SHORT).show()
        } else if (password != confirmPassword) {
            Toast.makeText(requireContext(), "Passwords Don't Match", Toast.LENGTH_SHORT).show()
        }

        viewModel.register(
            email,
            password
        )

    }
}