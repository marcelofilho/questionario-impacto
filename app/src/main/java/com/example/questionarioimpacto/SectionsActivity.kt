package com.example.questionarioimpacto

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.questionarioimpacto.SectionAdapter.ItemClick
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.models.ListSectionModel
import com.example.questionarioimpacto.models.QuestionIdModel
import com.example.questionarioimpacto.models.SectionModel
import com.google.gson.Gson
import java.util.*
import kotlinx.android.synthetic.main.activity_sections.*

class SectionsActivity : AppCompatActivity(), ItemClick {

    var arrayList: ArrayList<QuestionIdModel> = ArrayList()
    private var recyclerView: RecyclerView? = null
    private var incrementList = IncrementList()
    private lateinit var listSection: ListSectionModel
    private lateinit var viewModel: IdentificationViewModel
    private var sectionAdapter: SectionAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    var sectionExample: MutableList<SectionModel> = ArrayList()
    private lateinit var dwellerId: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sections)
        viewModel =  ViewModelProvider(this).get(IdentificationViewModel::class.java)
       listSection = Gson().fromJson(incrementList.loadJSONFromAsset(this,"section_list"),ListSectionModel::class.java)
        dwellerId = intent.getStringExtra("dwellerId")!!
//        arrayList = intent.getParcelableArrayListExtra<QuestionIdModel>("list")!!
        recyclerView = findViewById<View>(R.id.rv_sections) as RecyclerView
        mLayoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = mLayoutManager
//        sectionAdapter = SectionAdapter(listSection, this)
        recyclerView!!.adapter = sectionAdapter

    }


    override fun clickButton(id: String) {
        val bundle = Bundle()
        bundle.putString("ID", id)
        val intent = Intent(this@SectionsActivity, ThreatActivity::class.java)
        intent.putExtra("list",arrayList)
        intent.putExtra("dwellerId",dwellerId)
        intent.putExtras(bundle)
        startActivityForResult(intent, 1)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==2){
            sectionAdapter?.deleteItem(data!!.getStringExtra("sectionId")!!)
            if(sectionAdapter?.isEmpty()!!)
                button_send_section.visibility = View.VISIBLE
//            arrayList = data!!.getParcelableArrayListExtra<QuestionIdModel>("arrayList")!!
        }
    }

    fun send(view: View) {
        viewModel.postQuestion(arrayList)
    }


}