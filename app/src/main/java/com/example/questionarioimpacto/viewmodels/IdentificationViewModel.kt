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

//        RetrofitInitializer().service.getUsers()
//            .enqueue(object : Callback<List<User>> {
//                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                    response.body()?.let {
//                        sucessCallback(it)
//                        AsyncTask.execute {
//                            userDao.insertUsers(it)
//                        }
//                    }
//                }
//                override fun onFailure(call: Call<List<User>>, t: Throwable) {
//                    AsyncTask.execute {  val listUser = userDao.getAllUsers()
//                        if(listUser.isNotEmpty()){
//                            sucessCallback(userDao.getAllUsers())
//                        }else{
//                            failure(t.message)
//                        }}
//
//                }
//
//            })

        viewModelScope.launch {

            try {
                val dwellerIdResult =  MobileApi.retrofitService.getDwellerId()
                println(dwellerIdResult)
                _dwellerId.value = dwellerIdResult.body()
            }catch (e: Exception){
                _error.value = "Faileure: ${e.message} "
            }
        }

    }
}