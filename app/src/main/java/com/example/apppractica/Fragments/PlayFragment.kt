package com.example.apppractica.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apppractica.databinding.FragmentPlayBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PlayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayBinding.inflate(inflater, container,false)
        return binding.root
    }
}