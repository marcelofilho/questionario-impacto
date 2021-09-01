package com.example.questionarioimpacto.connection.Api

import androidx.lifecycle.LiveData
import com.example.questionarioimpacto.models.DwellerIdModel
import com.example.questionarioimpacto.models.QuestionIdModel
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface QuestionApi {

    @POST("saveListResponse")
    suspend fun  postQuestion(@Body question: ArrayList<QuestionIdModel>): Response<Void>

    @POST("postdwellerId")
    suspend fun  getDwellerId(): DwellerIdModel
}