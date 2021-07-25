package com.example.questionarioimpacto.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.questionarioimpacto.Base.BaseFragment
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.databinding.FragmentIndentificacaoBinding
import com.example.questionarioimpacto.databinding.FragmentInformacoesGeraisBinding
import com.example.questionarioimpacto.databinding.FragmentInformacoesGeraisBindingImpl
import com.example.questionarioimpacto.models.QuestionIdModel


class InformacoesGeraisFragment : BaseFragment<FragmentInformacoesGeraisBinding>() {

    companion object {

    }
    var sofreuReforma: String = ""
    var sexo: String = ""
    var idade: String = ""
    var renda: String = ""


    override fun getLayoutId(): Int = R.layout.fragment_informacoes_gerais


    override fun init() {

        setListenner()
    }

    private fun setListenner() {

        binding.nextScreen.setOnClickListener {
            receberTextosRadioButton()
            adicionandoNaLista()
            view?.findNavController()?.navigate(InformacoesGeraisFragmentDirections.actionInformacoesGeraisFragmentToSecaoFragment())
        }
    }
    private fun adicionandoNaLista(){
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel("dwellerId","005fb767-5f93-46dd-9f04-0d1157e47180",sofreuReforma,"5d41b0ce34e4386291d1a769"))
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel("dwellerId","cd5802b1-5902-4505-a3ca-943723b91aa0",sexo,"5d41b0ce34e4386291d1a769"))
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel("dwellerId","e98ec129-e897-42d2-aaa9-a4b82417842c",idade,"5d41b0ce34e4386291d1a769"))
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel("dwellerId","b621b73f-0851-46c5-9a1f-a0bed4ce9718",renda,"5d41b0ce34e4386291d1a769"))
    }

    private fun receberTextosRadioButton(){
        when(binding.sofreuReforma.checkedRadioButtonId){
            binding.sim.id -> sofreuReforma = "sim"
            binding.nao.id-> sofreuReforma = "nao"
        }
        when(binding.sexo.checkedRadioButtonId){
            binding.masculino.id -> sexo = "masculino"
            binding.feminino.id-> sexo = "feminino"
        }

        when(binding.idade.checkedRadioButtonId){
            binding.jovem.id -> idade = "Jovem – até 19 anos"
            binding.adulto.id-> idade = "Adulto – de 20 a 59 anos"
            binding.idoso.id-> idade = "Idoso – a partir de 60 anos de idade"
        }

        when(binding.renda.checkedRadioButtonId){
            binding.semRenda.id -> renda = "Não têm renda"
            binding.um.id-> renda = "1 a 2 salários mínimos"
            binding.dois.id-> renda = "2 a 3 salários mínimos"
            binding.tres.id-> renda = "3 a 4 salário mínimos "
            binding.quatro.id-> renda = "Mais de 4 salários mínimos"
        }
    }




}