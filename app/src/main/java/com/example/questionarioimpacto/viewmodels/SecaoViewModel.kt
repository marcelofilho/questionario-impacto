package com.example.questionarioimpacto.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questionarioimpacto.connection.MobileApi
import com.example.questionarioimpacto.models.QuestionIdModel
import kotlinx.coroutines.launch

class SecaoViewModel : ViewModel() {

    private val _sucesso: MutableLiveData<Boolean> = MutableLiveData()

    val sucesso: LiveData<Boolean>
        get() = _sucesso

    private val _error: MutableLiveData<String> = MutableLiveData()

    val error: LiveData<String>
        get() = _error

    fun postQuestion(array: ArrayList<QuestionIdModel> ){

        viewModelScope.launch {

            try {
                MobileApi.retrofitService.postQuestion(array)
                _sucesso.value = true

            }catch (e: Exception){
                _error.value = "Faileure: ${e.message} "
            }
        }


    }

}