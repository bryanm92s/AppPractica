package com.example.apppractica.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.MovieProvider
import com.example.apppractica.R
import com.example.apppractica.adapter.MovieAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BuscarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BuscarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_buscar, container, false)
        // Iniciar RecyclerView en un Fragment.
        // Dentro de onCreateView

        val recyclerView: RecyclerView = view.findViewById(R.id.movieRecycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = MovieAdapter(MovieProvider.movieList)
        return view

        // Agregar línea divisora
        /*val manager=LinearLayoutManager(view.context)
        val mDividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
           manager.orientation
        )

        recyclerView.addItemDecoration(mDividerItemDecoration)*/

    }

    // Iniciar RecyclerView en una actividad
    //val recyclerView = findViewById<RecyclerView>(R.id.movieRecycler)
    //movieRecycler.layoutManager = LinearLayoutManager(this)
    //recyclerView.adapter = MovieAdapter(MovieProvider.movieList)



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BuscarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BuscarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}