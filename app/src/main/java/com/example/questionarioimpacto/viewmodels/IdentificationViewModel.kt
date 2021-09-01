package com.example.questionarioimpacto.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questionarioimpacto.connection.Api.QuestionApi
import com.example.questionarioimpacto.connection.MobileApi
import com.example.questionarioimpacto.models.DwellerIdModel
import com.example.questionarioimpacto.models.QuestionIdModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IdentificationViewModel : ViewModel(){

//    private val service = NetworkUtils()
    private val _dwellerId: MutableLiveData<DwellerIdModel> = MutableLiveData()

    val dwellerId: LiveData<DwellerIdModel>
        get() = _dwellerId

    private val _error: MutableLiveData<String> = MutableLiveData()

    val error: LiveData<String>
        get() = _error


    init {

    }


    fun getDwellerId(){

        viewModelScope.launch {

            try {
                val dwellerIdResult =  MobileApi.retrofitService.getDwellerId()
                _dwellerId.value = dwellerIdResult
            }catch (e: Exception){
                _error.value = "Faileure: ${e.message} "
            }
        }

    }
}