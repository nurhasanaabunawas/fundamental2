package com.dicoding.caca.fundamental1.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIUser {

    companion object {
        fun getApiAsisst(): APIAsisst {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(APIAsisst::class.java)
        }
    }
}
