package com.example.questionarioimpacto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.questionarioimpacto.connection.NetworkUtils
import com.example.questionarioimpacto.models.DwellerIdModel
import com.example.questionarioimpacto.models.QuestionIdModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IdentificationViewModel : ViewModel(){

    private val service = NetworkUtils()
    var dwellerIdGenerate: MutableLiveData<String> = MutableLiveData()


    init {

    }

   fun postQuestion(array: ArrayList<QuestionIdModel> ){


       val call =  service.postQuestion().postQuestion(
              array
               )

       call .enqueue(object : Callback<Void> {
           override fun onFailure(call: Call<Void>?, t: Throwable?) {
               print("erro")
           }

           override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
              print("sucesso")
           }
       })
    }

    fun getDwellerId(){
        val call =  service.postQuestion().getDwellerId(
        )

        call .enqueue(object : Callback<DwellerIdModel> {
            override fun onFailure(call: Call<DwellerIdModel>?, t: Throwable?) {
                print("erro")
            }


            override fun onResponse(call: Call<DwellerIdModel>, response: Response<DwellerIdModel>) {
              dwellerIdGenerate.value = response.body()?.dwellerIdGenerate
            }
        })

    }
}