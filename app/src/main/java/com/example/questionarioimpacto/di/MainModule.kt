package com.example.questionarioimpacto.di

import com.example.questionarioimpacto.viewmodels.IdentificationViewModel
import com.example.questionarioimpacto.models.*
import com.example.questionarioimpacto.viewmodels.AmeacaViewModel
import com.example.questionarioimpacto.viewmodels.QuestoesViewModel
import com.example.questionarioimpacto.viewmodels.SecaoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val mainModule = module {


    single { ListQuestionIdModel() }
    single { SectionJsonModel() }
    single{ DwellerIdModel() }

    viewModel { AmeacaViewModel() }
    viewModel { QuestoesViewModel() }
    viewModel { IdentificationViewModel() }
    viewModel {SecaoViewModel()}
}