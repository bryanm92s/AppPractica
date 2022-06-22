package com.example.apppractica.Fragments


import BestMoviesAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.BestMoviesProvider.Companion.bestMovieList
import com.example.apppractica.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
        recyclerView.adapter =BestMoviesAdapter(bestMovieList)

        return binding.root

    }
}