package com.example.apppractica.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.detail.DetailMovieActivity
import com.example.apppractica.adapter.MovieAdapter
import com.example.apppractica.databinding.FragmentSearchBinding
import com.example.apppractica.models.MovieResponse
import com.example.apppractica.models.Movies
import com.example.apppractica.services.MovieApiInterface
import com.example.apppractica.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? =null
    private val binding get() = _binding!!

    var movies: List<Movies>? = null
    private lateinit var movieAdapter: MovieAdapter

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        // Agregar línea de división
        val recyclerView: RecyclerView = binding.movieRecycler
        val manager=LinearLayoutManager(context)
        val mDividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            manager.orientation
        )
        recyclerView.addItemDecoration(mDividerItemDecoration)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.movieRecycler.layoutManager = LinearLayoutManager(activity)
        binding.movieRecycler.setHasFixedSize(true)
        getMovieData { movieList: List<Movies> ->
            binding.movieRecycler.adapter = MovieAdapter(movieList, object : MovieAdapter.OnAdapterListener {
                override fun onClick(result: Movies) {
                    val intent = Intent(activity, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_DATA, result)
                    startActivity(intent)
                }
            })
        }
    }

    private fun setupRecyclerView(){
        movieAdapter = MovieAdapter(arrayListOf(), object : MovieAdapter.OnAdapterListener {
            override fun onClick(result: Movies) { val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, result)
                startActivity(intent)
            }
        })
        binding.movieRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }
    }
    private fun getMovieData(callback: (List<Movies>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movies = response.body()!!.Movies
                return callback(response.body()!!.Movies)
            }
        })
    }
}