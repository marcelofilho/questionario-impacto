package com.example.questionarioimpacto.fragmentos

import androidx.navigation.findNavController
import com.example.questionarioimpacto.Base.BaseFragment
import com.example.questionarioimpacto.viewmodels.IdentificationViewModel
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.databinding.FragmentIndentificacaoBinding
import com.example.questionarioimpacto.models.ListSectionModel
import com.example.questionarioimpacto.models.QuestionIdModel
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*


class IndentificacaoFragment : BaseFragment<FragmentIndentificacaoBinding>() {

    private var incrementList = IncrementList()
    var rightNow = Calendar.getInstance()
    val data = Date()
    val formataData = SimpleDateFormat("dd-MM-yyyy")

    val viewModel: IdentificationViewModel by viewModel()

    override fun init() {
        arrayListQuestionModel.questionIdModelList.clear()
        listSection.listsectionModel.listSection.clear()
        println(arrayListQuestionModel)
        println(listSection)
        listSection.listsectionModel = Gson().fromJson(
            incrementList.loadJSONFromAsset(context, "section_list"),
            ListSectionModel::class.java
        )
        setListenners()
        setObervers()
        viewModel.getDwellerId()
    }

    private fun setObervers() {
        viewModel.dwellerId.observe(viewLifecycleOwner, androidx.lifecycle.Observer  {
            dwellerIdModel.dwellerId = it.dwellerId
        })
    }

    override fun getLayoutId(): Int = R.layout.fragment_indentificacao


    private fun setListenners() {
      binding.toNextFragment.setOnClickListener {
          adicionarLista()
          view?.findNavController()?.navigate(IndentificacaoFragmentDirections.actionIndentificacaoFragmentToInformacoesGeraisFragment())
      }
    }

    private fun adicionarLista() {
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel(dwellerIdModel.dwellerId , "07b700c0-2ed3-4fc4-bc85-117058d53a2f", binding.endereco.text.toString(), "5d41b0ce34e4386291d1a769"))
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel(dwellerIdModel.dwellerId , "577350b6-fad1-4d1e-b214-b531ea4028ce", formataData.format(data), "5d41b0ce34e4386291d1a769"))
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel(dwellerIdModel.dwellerId , "93808a97-9bab-4f05-901b-382c7fcb0dc9", getHour(), "5d41b0ce34e4386291d1a769"))
        arrayListQuestionModel.questionIdModelList.add(QuestionIdModel(dwellerIdModel.dwellerId , "fcdbf778-c92d-46b7-876f-b02af4aa8026", binding.telefone.text.toString(), "5d41b0ce34e4386291d1a769"))
    }

    private fun getHour(): String{
        return  (rightNow.get(Calendar.HOUR_OF_DAY)-3).toString() + ":" +rightNow.get(Calendar.MINUTE).toString()
    }




}