package com.example.questionarioimpacto.connection

import com.example.questionarioimpacto.connection.Api.QuestionApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "http://200.131.206.11:8080/api/mobile/"
//class NetworkUtils {
//
//    private fun httpClient(): OkHttpClient {
//        val clientBuilder = OkHttpClient.Builder()
//
//            val httpLoggingInterceptor =
//                    HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//            clientBuilder.addInterceptor(httpLoggingInterceptor)
//
//
//        return clientBuilder
//                .build()
//    }
//
//
//     private val api = Retrofit.Builder()
//            .baseUrl(BASE_URL).client(httpClient())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//
//
//   fun postQuestion(): QuestionApi {
//      return  api.create(QuestionApi::class.java)
//   }
//
//}

    private fun httpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()

            val httpLoggingInterceptor =
                    HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)


        return clientBuilder
                .build()
    }



private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL).client(httpClient()).addConverterFactory(GsonConverterFactory.create())
    .build()

object MobileApi {
    val retrofitService: QuestionApi by lazy {
        retrofit.create(QuestionApi::class.java)
    }
}