package com.example.questionarioimpacto.fragmentos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
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
import com.example.questionarioimpacto.databinding.FragmentMostrarMaisBinding
import com.example.questionarioimpacto.databinding.FragmentTermosCondicoesBinding


class MostrarMaisFragment : Fragment() {
    companion object {
        const val CLICK_AQUI = "Clique aqui"
        const val VOLTAR = "Voltar"
    }

    private lateinit var binding: FragmentMostrarMaisBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_mostrar_mais, container, false)
        setListenner()
        setLayout()
        return binding.root

    }

    private fun setListenner() {
        binding.clickHereTv.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://morahabitacao.com/pesquisas-em-andamento-2/ber_home-resiliencia-no-ambiente-construido-em-habitacao-social-metodos-de-avaliacao-tecnologicamente-avancados/)"))
            startActivity(browserIntent)
        }

        binding.tvBack.setOnClickListener {
            requireFragmentManager().popBackStack()
        }
    }


    private fun setLayout() {
        binding.apply {
            val clickAqui = SpannableString(CLICK_AQUI)
            val voltar = VOLTAR
            clickAqui.setSpan(UnderlineSpan(), 0, clickAqui.length, 0)
          clickHereTv.text = clickAqui
            tvLabelShowMore.text = Html.fromHtml(getString(R.string.texto_mostrar_mais))
            val contentBack = SpannableString(VOLTAR)
            contentBack.setSpan(UnderlineSpan(), 0, contentBack.length, 0)
            tvBack.text = contentBack

        }
    }


}