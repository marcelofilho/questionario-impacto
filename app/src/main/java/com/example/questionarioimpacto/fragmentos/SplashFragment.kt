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
import com.example.questionarioimpacto.Base.BaseFragment
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.TermsConditionsActivity
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.databinding.FragmentSplashBinding
import com.example.questionarioimpacto.models.ListSectionModel
import com.google.gson.Gson


class SplashFragment : BaseFragment<FragmentSplashBinding>() {



    override fun getLayoutId() = R.layout.fragment_splash

    override fun init() {
        val handle = Handler()
        handle.postDelayed({ mostrarLogin() }, 2000)

    }

    private fun mostrarLogin() {
        view?.findNavController()
            ?.navigate(SplashFragmentDirections.actionSplashFragmentToTermosCondicoesFragment())
    }


}