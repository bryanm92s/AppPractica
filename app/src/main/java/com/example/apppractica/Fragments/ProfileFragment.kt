package com.example.apppractica.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.ProfileProvider.Companion.profileList
import com.example.apppractica.adapter.ProfileAdapter
import com.example.apppractica.databinding.FragmentProfileBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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