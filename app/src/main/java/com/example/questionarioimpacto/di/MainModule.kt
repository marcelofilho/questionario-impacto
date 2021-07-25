package com.example.questionarioimpacto.di

import com.example.questionarioimpacto.models.ListQuestionIdModel
import com.example.questionarioimpacto.models.QuestionIdModel
import com.example.questionarioimpacto.viewmodels.AmeacaViewModel
import com.example.questionarioimpacto.viewmodels.QuestoesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val mainModule = module{


    single{ListQuestionIdModel()}

    viewModel{ AmeacaViewModel() }
    viewModel{ QuestoesViewModel() }
}