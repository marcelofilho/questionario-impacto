package com.example.questionarioimpacto.fragmentos


import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.questionarioimpacto.Base.BaseFragment
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.adapters.QuestionsAdapter
import com.example.questionarioimpacto.adapters.ThreatAdapter
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.databinding.FragmentQuestoesBinding
import com.example.questionarioimpacto.models.QuestionIdModel
import com.example.questionarioimpacto.models.QuestionListModel
import com.example.questionarioimpacto.viewmodels.QuestoesViewModel
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuestoesFragment : BaseFragment<FragmentQuestoesBinding>(),
    QuestionsAdapter.QuestionListenner {

    companion object {

    }

    private var incrementList = IncrementList()
    private lateinit var args: QuestoesFragmentArgs
    private lateinit var idSection: String
    private lateinit var questionList: QuestionListModel
    private var questionsAdapter: QuestionsAdapter? = null

    private val questoesViewModel: QuestoesViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_questoes

    override fun init() {

        args =QuestoesFragmentArgs.fromBundle(requireArguments())
        idSection = args.idAmeaca
        questionList = Gson().fromJson(incrementList.loadJSONFromAsset(context, "question_list"), QuestionListModel::class.java)
        setAdapter()
        setListenners()
    }

    private fun setListenners() {
        binding.include4.buttonNext.setOnClickListener {
            adicionarList()
            view?.findNavController()?.navigate(QuestoesFragmentDirections.actionQuestoesFragmentToSecaoFragment(idSection))
        }
    }

    private fun setAdapter() {
        val layoutManager = LinearLayoutManager(context)
        binding.rvQuestions.setLayoutManager(layoutManager)
        questionsAdapter = QuestionsAdapter(questoesViewModel.filtrarList(questionList, idSection), this)
        binding.rvQuestions.setAdapter(questionsAdapter)
    }


    override fun atualizarStatus(id: String?, status: String?) {
        questionList.questionList?.find {it.id == id}?.state = status
    }

    fun adicionarList(){
        questionList.questionList?.forEach{

            when(it.state){
                "Pouco" ->  arrayListQuestionModel.questionIdModelList.add(QuestionIdModel(dwellerIdModel.dwellerId , it.id, "pouco", "5d41b0ce34e4386291d1a769"))
                "Muito" ->  arrayListQuestionModel.questionIdModelList.add(QuestionIdModel(dwellerIdModel.dwellerId , it.id, "muito", "5d41b0ce34e4386291d1a769"))
                "Nenhum" ->  arrayListQuestionModel.questionIdModelList.add(QuestionIdModel(dwellerIdModel.dwellerId , it.id, "nenhum", "5d41b0ce34e4386291d1a769"))
            }

        }
    }
}