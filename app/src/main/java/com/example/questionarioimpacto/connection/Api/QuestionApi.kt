package com.example.questionarioimpacto.connection.Api

import androidx.lifecycle.LiveData
import com.example.questionarioimpacto.models.DwellerIdModel
import com.example.questionarioimpacto.models.QuestionIdModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface QuestionApi {

    @POST("saveListResponse")
    fun  postQuestion(@Body question: ArrayList<QuestionIdModel>): Call<Void>

    @POST("postdwellerId")
    fun  getDwellerId(): Call<DwellerIdModel>
}