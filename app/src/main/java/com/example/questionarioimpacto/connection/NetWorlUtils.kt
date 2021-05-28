package com.example.questionarioimpacto.connection

import com.example.questionarioimpacto.connection.Api.QuestionApi
import com.example.questionarioimpacto.models.QuestionIdModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {




    private fun httpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()

            val httpLoggingInterceptor =
                    HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)


        return clientBuilder
                .build()
    }


     private val api = Retrofit.Builder()
            .baseUrl("http://200.131.206.11:8080/api/mobile/").client(httpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()



   fun postQuestion(): QuestionApi {
      return  api.create(QuestionApi::class.java)
   }


}