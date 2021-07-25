package com.example.questionarioimpacto.fragmentos

import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.questionarioimpacto.Base.BaseFragment
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.SectionAdapter
import com.example.questionarioimpacto.connection.IncrementList
import com.example.questionarioimpacto.databinding.FragmentSecaoBinding
import com.example.questionarioimpacto.models.ListSectionModel
import com.google.gson.Gson


class SecaoFragment : BaseFragment<FragmentSecaoBinding>(), SectionAdapter.ItemClick {


    companion object {

    }

    private var sectionAdapter: SectionAdapter? = null
    private lateinit var listSection: ListSectionModel
    private var incrementList = IncrementList()
    private var recyclerView: RecyclerView? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun getLayoutId(): Int = R.layout.fragment_secao
    override fun init() {

        setListenners()
        listSection = Gson().fromJson(incrementList.loadJSONFromAsset(context,"section_list"),
            ListSectionModel::class.java)
//        arrayList = intent.getParcelableArrayListExtra<QuestionIdModel>("list")!!
        mLayoutManager = LinearLayoutManager(context)
        binding.rvSections.layoutManager = mLayoutManager
        sectionAdapter = SectionAdapter(listSection, this)
        binding.rvSections!!.adapter = sectionAdapter
    }

    private fun setListenners() {

    }




    override fun clickButton(id: String) {
        view?.findNavController()?.navigate(SecaoFragmentDirections.actionSecaoFragmentToAmeacaFragment(id))
    }

}