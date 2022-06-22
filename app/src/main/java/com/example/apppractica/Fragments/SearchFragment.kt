package com.example.apppractica.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.MovieProvider.Companion.movieList
import com.example.apppractica.adapter.MovieAdapter
import com.example.apppractica.databinding.FragmentSearchBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
        recyclerView.adapter = MovieAdapter(movieList)

        // Agregar línea divisora
        val manager=LinearLayoutManager(context)
        val mDividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            manager.orientation
        )

        recyclerView.addItemDecoration(mDividerItemDecoration)

        return binding.root
    }
}