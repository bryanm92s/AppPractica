package com.example.apppractica.services


import com.example.apppractica.API_KEY
import com.example.apppractica.models.BestMovieResponse
import com.example.apppractica.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET



interface MovieApiInterface {
    @GET("/3/movie/top_rated?api_key=$API_KEY")
    fun getBestMovieList(): Call<BestMovieResponse>

    @GET("/3/list/1?api_key=$API_KEY")
    fun getMovieList(): Call<MovieResponse>
}