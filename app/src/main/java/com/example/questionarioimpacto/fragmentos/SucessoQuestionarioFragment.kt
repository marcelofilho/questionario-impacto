package com.example.questionarioimpacto.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.questionarioimpacto.Base.BaseFragment
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.databinding.FragmentSucessoQuestionarioBinding

class SucessoQuestionarioFragment : BaseFragment<FragmentSucessoQuestionarioBinding>() {


    override fun init() {
        setListenners()
    }

    private fun setListenners() {
        binding.acceptButton.setOnClickListener {
            view?.findNavController()?.navigate(SucessoQuestionarioFragmentDirections.actionSucessoQuestionarioFragmentToIndentificacaoFragment())
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_sucesso_questionario


}