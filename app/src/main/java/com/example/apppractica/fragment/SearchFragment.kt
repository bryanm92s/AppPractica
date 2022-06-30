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
import com.example.apppractica.provider.MovieProvider.Companion.movieList
import com.example.apppractica.databinding.FragmentSearchBinding

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

        // Agregar línea de división
        val manager=LinearLayoutManager(context)
        val mDividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            manager.orientation
        )

        recyclerView.addItemDecoration(mDividerItemDecoration)

        return binding.root
    }
}