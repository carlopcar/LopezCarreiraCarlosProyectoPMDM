package com.example.lopezcarreiracarlosproyectopmdm

import com.example.lopezcarreiracarlosproyectopmdm.model.dao.retrofit.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl("https://damapi.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit
    }

    val apiRetrofit = getRetrofit().create(Api::class.java)
}