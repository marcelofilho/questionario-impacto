package com.example.questionarioimpacto.fragmentos

import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.questionarioimpacto.Base.BaseFragment
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.adapters.ThreatAdapter
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.databinding.FragmentAmeacaBinding
import com.example.questionarioimpacto.models.QuestionIdModel
import com.example.questionarioimpacto.models.ThreatListModel
import com.example.questionarioimpacto.viewmodels.AmeacaViewModel
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel


class AmeacaFragment : BaseFragment<FragmentAmeacaBinding>() {


    companion object {
    }
    private var threatAdapter: ThreatAdapter? = null
    private lateinit var idSection: String
    private lateinit var threatList: ThreatListModel
    private var incrementList = IncrementList()
    private lateinit var args: AmeacaFragmentArgs

    private val viewModel: AmeacaViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_ameaca

    override fun init() {
        threatList = Gson().fromJson(incrementList.loadJSONFromAsset(context,"threat_list"), ThreatListModel::class.java)
        args =AmeacaFragmentArgs.fromBundle(requireArguments())
        idSection = args.idAmeaca
        threatList.listThreat = viewModel.filtrarList(threatList, idSection!!)
        setAdapter()
        setListenners()

    }
    private fun setAdapter() {
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setLayoutManager(layoutManager)
        threatAdapter = ThreatAdapter(threatList.listThreat!!, this)
        binding.recyclerView?.setAdapter(threatAdapter)
    }

    private fun setListenners() {
        binding.include2.buttonNext.setOnClickListener {
            addListQuestion()
            view?.findNavController()?.navigate(AmeacaFragmentDirections.actionAmeacaFragmentToQuestoesFragment(idSection))
        }
    }

    fun addListQuestion(){
        threatList.listThreat?.forEach{
            if(it.isSCheck){
                arrayListQuestionModel.questionIdModelList.add(QuestionIdModel(dwellerIdModel.dwellerIdGenerate ,it.id,"sim","5d41b0ce34e4386291d1a769"))
            }
            else {
                arrayListQuestionModel.questionIdModelList.add(QuestionIdModel(dwellerIdModel.dwellerIdGenerate ,it.id,"não","5d41b0ce34e4386291d1a769"))
            }
        }
    }









}