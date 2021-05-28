package com.example.questionarioimpacto.fragmentos

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.TermsConditionsActivity
import com.example.questionarioimpacto.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSplashBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_splash, container, false)

        val handle = Handler()
        handle.postDelayed({ mostrarLogin() }, 2000)

        return binding.root
    }

    private fun mostrarLogin() {
        view?.findNavController()?.navigate(SplashFragmentDirections.actionSplashFragmentToTermosCondicoesFragment())
    }


}