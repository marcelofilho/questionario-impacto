package com.example.questionarioimpacto.Base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.models.*
import org.koin.android.ext.android.inject


abstract class BaseFragment <T : ViewDataBinding> : Fragment()  {


    val arrayListQuestionModel: ListQuestionIdModel by inject()
    val listSection: SectionJsonModel by inject()
    val dwellerIdModel: DwellerIdModel by inject()


    abstract fun init()
    abstract fun getLayoutId(): Int
    lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.apply { lifecycleOwner = viewLifecycleOwner }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


}