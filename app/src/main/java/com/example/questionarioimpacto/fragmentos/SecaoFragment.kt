package com.example.questionarioimpacto.fragmentos

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.questionarioimpacto.Base.BaseFragment
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.adapters.SectionAdapter
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.databinding.FragmentSecaoBinding
import com.example.questionarioimpacto.models.ListSectionModel
import com.example.questionarioimpacto.viewmodels.SecaoViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_sections.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SecaoFragment : BaseFragment<FragmentSecaoBinding>(), SectionAdapter.ItemClick {


    private var sectionAdapter: SectionAdapter? = null
    private lateinit var args: SecaoFragmentArgs
    private lateinit var idSection: String
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    private val secaoViewModel: SecaoViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_secao
    override fun init() {
        args =SecaoFragmentArgs.fromBundle(requireArguments())
        idSection = args.idAmeaca!!
        setListenners()
        setObervers()
        if(idSection!="0"){
            listSection.listsectionModel.listSection.removeAll{it.id==idSection}
        }
//        arrayList = intent.getParcelableArrayListExtra<QuestionIdModel>("list")!!
        setAdapter()
        verificarQuestionarioCompleto()

    }

    private fun setObervers() {
        secaoViewModel.sucesso.observe(viewLifecycleOwner, androidx.lifecycle.Observer  {
           if(true)
               view?.findNavController()?.navigate(SecaoFragmentDirections.actionSecaoFragmentToSucessoQuestionarioFragment())
        })
    }

    private fun verificarQuestionarioCompleto() {
        if(listSection.listsectionModel.listSection.isEmpty())
            binding.buttonSendSection.visibility = View.VISIBLE
    }

    private fun deleteSectionItem() {
        sectionAdapter?.deleteItem(idSection)
        if(sectionAdapter?.isEmpty()!!)
            button_send_section.visibility = View.VISIBLE
    }

    private fun setAdapter() {
        mLayoutManager = LinearLayoutManager(context)
        binding.rvSections.layoutManager = mLayoutManager
        sectionAdapter = SectionAdapter(listSection.listsectionModel.listSection, this)
        binding.rvSections.adapter = sectionAdapter
    }

    private fun setListenners() {
        binding.buttonSendSection.setOnClickListener {
            secaoViewModel.postQuestion(arrayListQuestionModel.questionIdModelList)
        }
    }




    override fun clickButton(id: String) {
        view?.findNavController()?.navigate(SecaoFragmentDirections.actionSecaoFragmentToAmeacaFragment(id))
    }

}