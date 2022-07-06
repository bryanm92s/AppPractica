package com.example.apppractica.services


import com.example.apppractica.models.BestMovieResponse
import com.example.apppractica.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/top_rated?api_key=c5c47722a4adcc77f6e84f28a48b857a")
    fun getBestMovieList(): Call<BestMovieResponse>

    @GET("/3/list/1?api_key=c5c47722a4adcc77f6e84f28a48b857a")
    fun getMovieList(): Call<MovieResponse>
}