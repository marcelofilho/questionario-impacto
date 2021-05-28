package com.example.questionarioimpacto.fragmentos

import android.os.Bundle
import android.os.Handler
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.databinding.FragmentSplashBinding
import com.example.questionarioimpacto.databinding.FragmentTermosCondicoesBinding
import kotlinx.android.synthetic.main.fragment_termos_condicoes.*


class TermosCondicoesFragment : Fragment() {

    private lateinit var binding: FragmentTermosCondicoesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_termos_condicoes, container, false)
        val content = SpannableString("Saiba mais")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        binding.tvShowMore.text= content
        setListenners()
        return binding.root
    }

    private fun setListenners() {

        binding.apply {
            tvShowMore.setOnClickListener {
                view?.findNavController()?.navigate(TermosCondicoesFragmentDirections.actionTermosCondicoesFragmentToMostrarMaisFragment())
            }

            acceptButton.setOnClickListener {
                view?.findNavController()?.navigate(TermosCondicoesFragmentDirections.actionTermosCondicoesFragmentToIndentificacaoFragment())
            }
        }
    }


}