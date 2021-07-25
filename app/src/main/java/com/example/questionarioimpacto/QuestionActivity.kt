package com.example.questionarioimpacto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.questionarioimpacto.adapters.QuestionsAdapter
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.models.QuestionIdModel
import com.example.questionarioimpacto.models.QuestionListModel
import com.example.questionarioimpacto.models.QuestionModel
import com.google.gson.Gson
import java.util.*

class QuestionActivity : AppCompatActivity(), QuestionsAdapter.QuestionListenner {
    private var mRecyclerView: RecyclerView? = null
    private var questionsAdapter: QuestionsAdapter? = null
    private var incrementList = IncrementList()
    private val questionListOld: MutableList<String> = ArrayList()
    var arrayList: ArrayList<QuestionIdModel> = ArrayList()
    private lateinit var questionList: QuestionListModel
    private lateinit var dwellerId: String
    private var buttonNext: Button? = null
    private var buttonBack: Button? = null
    private var id: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
//        arrayList = intent.getParcelableArrayListExtra<QuestionIdModel>("list")!!
        dwellerId = intent.getStringExtra("dwellerId")!!
        questionList = Gson().fromJson(incrementList.loadJSONFromAsset(this, "question_list"), QuestionListModel::class.java)
        mRecyclerView = findViewById(R.id.rv_questions)
        val view = findViewById<View>(R.id.include2)
        buttonNext = view.findViewById<View>(R.id.button_next) as Button
        buttonBack = view.findViewById<View>(R.id.button_back) as Button
        id = intent.extras!!.getString("ID")
        val layoutManager = LinearLayoutManager(this)
        mRecyclerView?.setLayoutManager(layoutManager)
        questionsAdapter = QuestionsAdapter(filtrarList(questionList), this)
        mRecyclerView?.setAdapter(questionsAdapter)
        buttonNext!!.setOnClickListener {
            adicionarList()
            val output = Intent()
            output.putExtra("sectionId",id)
            output.putExtra("arrayList",arrayList)
            setResult(2,output)
            finish()
        }
        buttonBack!!.setOnClickListener { onBackPressed() }
    }

    fun adicionarList(){
        questionList.questionList?.forEach{

            when(it.state){
                "Pouco" -> arrayList.add(QuestionIdModel(dwellerId, it.id, "pouco", "5d41b0ce34e4386291d1a769"))
                "Muito" -> arrayList.add(QuestionIdModel(dwellerId, it.id, "muito", "5d41b0ce34e4386291d1a769"))
                "Nenhum" -> arrayList.add(QuestionIdModel(dwellerId, it.id, "nenhum", "5d41b0ce34e4386291d1a769"))
            }

        }
    }

    override fun atualizarStatus(id: String, status: String?) {
        questionList.questionList?.find {it.id == id}?.state = status

        }

     private fun filtrarList(list: QuestionListModel): ArrayList<QuestionModel> {
         var questionList: ArrayList<QuestionModel> = ArrayList()
         list.questionList?.forEach(){
             if(it.sectionId.equals(id))
                 questionList.add(it)
         }
         return questionList
     }



}