package com.example.apppractica.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.adapter.MovieAdapter
import com.example.apppractica.databinding.FragmentSearchBinding
import com.example.apppractica.models.BestMovieResponse
import com.example.apppractica.models.BestMovies
import com.example.apppractica.models.MovieResponse
import com.example.apppractica.models.Movies
import com.example.apppractica.services.MovieApiInterface
import com.example.apppractica.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container,false)

        val recyclerView: RecyclerView = binding.movieRecycler
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        getMovieData { MovieList: List<Movies> ->
            recyclerView.adapter = MovieAdapter(MovieList)
        }

        // Agregar línea de división
        val manager=LinearLayoutManager(context)
        val mDividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            manager.orientation
        )

        recyclerView.addItemDecoration(mDividerItemDecoration)

        return binding.root
    }

    private  fun getMovieData(callback:(List<Movies>)->Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.Movies)
            }
        })
    }
}