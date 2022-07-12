package com.example.apppractica.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.adapter.ProfileAdapter
import com.example.apppractica.databinding.FragmentProfileBinding
import com.example.apppractica.provider.ProfileProvider.Companion.profileList

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container,false)

        val recyclerView: RecyclerView = binding.reciclerViewOperaciones
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ProfileAdapter(profileList)

        return binding.root

    }
}