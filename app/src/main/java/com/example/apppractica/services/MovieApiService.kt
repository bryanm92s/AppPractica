package com.example.apppractica.services

import com.example.apppractica.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiService {
    companion object{

        private var retrofit: Retrofit?=null

        fun getInstance(): Retrofit {
            if (retrofit==null){
                retrofit= Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory((GsonConverterFactory.create()))
                    .build()
            }
            return retrofit!!
        }

    }
}