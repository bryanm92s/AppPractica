package com.example.apppractica.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.adapter.BestMoviesAdapter
import com.example.apppractica.databinding.FragmentHomeBinding
import com.example.apppractica.models.BestMovieResponse
import com.example.apppractica.models.BestMovies
import com.example.apppractica.services.MovieApiInterface
import com.example.apppractica.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container,false)


        val recyclerView: RecyclerView = binding.firstRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)

        getMovieData { bestMovieList: List<BestMovies> ->
            recyclerView.adapter = BestMoviesAdapter(bestMovieList)
        }

        return binding.root

    }

    private  fun getMovieData(callback:(List<BestMovies>)->Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getBestMovieList().enqueue(object : Callback<BestMovieResponse> {
            override fun onFailure(call: Call<BestMovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<BestMovieResponse>, response: Response<BestMovieResponse>) {
                return callback(response.body()!!.BestMovies)
            }
        })
    }
}