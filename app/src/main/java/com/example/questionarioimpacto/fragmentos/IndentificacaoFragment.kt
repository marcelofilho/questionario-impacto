package com.example.questionarioimpacto.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.questionarioimpacto.Base.BaseFragment
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.databinding.FragmentIndentificacaoBinding
import com.example.questionarioimpacto.databinding.FragmentSplashBinding
import com.example.questionarioimpacto.databinding.FragmentTermosCondicoesBinding
import com.example.questionarioimpacto.models.QuestionIdModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class IndentificacaoFragment : BaseFragment<FragmentIndentificacaoBinding>() {


    var rightNow = Calendar.getInstance()
    val data = Date()
    val formataData = SimpleDateFormat("dd-MM-yyyy")

    override fun init() {
        setListenners()
    }

    override fun getLayoutId(): Int = R.layout.fragment_indentificacao


    private fun setListenners() {
      binding.toNextFragment.setOnClickListener {
          adicionarLista()
          view?.findNavController()?.navigate(IndentificacaoFragmentDirections.actionIndentificacaoFragmentToInformacoesGeraisFragment())
      }
    }

    private fun adicionarLista() {
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel("dwellerId", "07b700c0-2ed3-4fc4-bc85-117058d53a2f", binding.endereco.text.toString(), "5d41b0ce34e4386291d1a769"))
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel("dwellerId", "577350b6-fad1-4d1e-b214-b531ea4028ce", formataData.format(data), "5d41b0ce34e4386291d1a769"))
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel("dwellerId", "93808a97-9bab-4f05-901b-382c7fcb0dc9", getHour(), "5d41b0ce34e4386291d1a769"))
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel("dwellerId", "fcdbf778-c92d-46b7-876f-b02af4aa8026", binding.telefone.text.toString(), "5d41b0ce34e4386291d1a769"))
    }

    private fun getHour(): String{
        return  (rightNow.get(Calendar.HOUR_OF_DAY)-3).toString() + ":" +rightNow.get(Calendar.MINUTE).toString()
    }




}