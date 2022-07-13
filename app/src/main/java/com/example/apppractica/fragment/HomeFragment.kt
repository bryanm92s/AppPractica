package com.example.apppractica.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apppractica.detail.DetailBestMovieActivity
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

    private var _binding: FragmentHomeBinding? =null
    private val binding get() = _binding!!

    var movies: List<BestMovies>? = null
    private lateinit var movieAdapter: BestMoviesAdapter

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.firstRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.firstRecyclerView.setHasFixedSize(true)

        getMovieData { bestMovieList: List<BestMovies> ->
            binding.firstRecyclerView.adapter = BestMoviesAdapter(bestMovieList, object : BestMoviesAdapter.OnAdapterListener {
                override fun onClick(result: BestMovies) {
                    val intent = Intent(activity, DetailBestMovieActivity::class.java)
                    intent.putExtra(DetailBestMovieActivity.EXTRA_DATA, result)
                    startActivity(intent)
                }
            })
        }
    }

    private fun setupRecyclerView(){
        movieAdapter = BestMoviesAdapter(arrayListOf(), object : BestMoviesAdapter.OnAdapterListener {
            override fun onClick(result: BestMovies) { val intent = Intent(activity, DetailBestMovieActivity::class.java)
                intent.putExtra(DetailBestMovieActivity.EXTRA_DATA, result)
                startActivity(intent)
            }
        })
        binding.firstRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter

        }
    }
    private fun getMovieData(callback: (List<BestMovies>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getBestMovieList().enqueue(object : Callback<BestMovieResponse> {
            override fun onFailure(call: Call<BestMovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<BestMovieResponse>, response: Response<BestMovieResponse>) {
                movies = response.body()!!.BestMovies
                return callback(response.body()!!.BestMovies)
            }
        })
    }
}