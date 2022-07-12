package com.example.apppractica.services


import com.example.apppractica.models.BestMovieResponse
import com.example.apppractica.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

const val API_KEY = "c5c47722a4adcc77f6e84f28a48b857a"

interface MovieApiInterface {
    @GET("/3/movie/top_rated?api_key=$API_KEY")
    fun getBestMovieList(): Call<BestMovieResponse>

    @GET("/3/list/1?api_key=$API_KEY")
    fun getMovieList(): Call<MovieResponse>
}