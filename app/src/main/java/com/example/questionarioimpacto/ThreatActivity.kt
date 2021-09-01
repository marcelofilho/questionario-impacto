package com.example.questionarioimpacto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.questionarioimpacto.adapters.ThreatAdapter
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.models.*
import com.example.questionarioimpacto.viewmodels.IdentificationViewModel
import com.google.gson.Gson
import kotlin.collections.ArrayList

class ThreatActivity : AppCompatActivity(), ThreatAdapter.ManipularListaQuestaoListenner     {

    var arrayList: ArrayList<QuestionIdModel> = ArrayList()
    private var mRecyclerView: RecyclerView? = null
    private var threatAdapter: ThreatAdapter? = null
    private var incrementList = IncrementList()
    private lateinit var viewModel: IdentificationViewModel
    private val thratList: MutableList<ThreatModel> = ArrayList()
    private var atualThreatList: List<ThreatModel> = ArrayList()
    private lateinit var threatList: ThreatListModel
    private var buttonNext: Button? = null
    private var buttonBack: Button? = null
    private var id: String? = null
    private lateinit var dwellerId: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_threat)
        val view = findViewById<View>(R.id.include2)
        viewModel =  ViewModelProvider(this).get(IdentificationViewModel::class.java)
//        arrayList = intent.getParcelableArrayListExtra<QuestionIdModel>("list")!!
        dwellerId = intent.getStringExtra("dwellerId")!!
        threatList = Gson().fromJson(incrementList.loadJSONFromAsset(this,"threat_list"), ThreatListModel::class.java)
        id = intent.extras!!.getString("ID")
        buttonNext = view.findViewById<View>(R.id.button_next) as Button
        buttonBack = view.findViewById<View>(R.id.button_back) as Button
        mRecyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        mRecyclerView?.setLayoutManager(layoutManager)
//        threatAdapter = ThreatAdapter(filtrarList(threatList), this, this)
        mRecyclerView?.setAdapter(threatAdapter)

        buttonNext!!.setOnClickListener {
            val intent = Intent(this@ThreatActivity, QuestionActivity::class.java)
            val bundle = Bundle()
            threatList.listThreat = filtrarList(threatList)
            addListQuestion()
            intent.putExtra("list",arrayList)
            intent.putExtra("dwellerId",dwellerId)
            bundle.putString("ID", id)
            intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT)
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }
        buttonBack!!.setOnClickListener { onBackPressed() }
    }

    fun addListQuestion(){
        threatList.listThreat?.forEach{
            if(it.isSCheck){
                arrayList.add(QuestionIdModel(dwellerId,it.id,"sim","5d41b0ce34e4386291d1a769"))
            }
            else {
                arrayList.add(QuestionIdModel(dwellerId,it.id,"não","5d41b0ce34e4386291d1a769"))
            }
        }

    }

    override fun addList(id: String, isCheck: Boolean) {
        thratList.find { it.id ==id }?.setCheck(isCheck)
    }

    override fun removeList() {
        TODO("Not yet implemented")
    }
    private fun filtrarList(list: ThreatListModel): ArrayList<ThreatModel>{
        var threatList: ArrayList<ThreatModel> = ArrayList()
        list.listThreat?.forEach(){
            if(it.sectionId.equals(id))
                threatList.add(it)
        }
        return threatList
    }
}