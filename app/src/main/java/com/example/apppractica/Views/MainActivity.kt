package com.example.apppractica.Views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.adapter.MovieAdapter
import com.example.apppractica.MovieProvider
import com.example.apppractica.Movies
import com.example.apppractica.R
import com.example.apppractica.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_inicio.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var movielist: ArrayList<Movies>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instancia del view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // -- Init Recycler
        // llamar a la función initRecyclerView()

        // Iniciar NavigationBottom con binding

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavigationView
        // Sincronización del navController con nuestro bottom navigation
        bottomNavigationView.setupWithNavController(navController)


        // Iniciar NavigationBottom con R.id

        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        //navController = navHostFragment.navController
        //val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        //setupWithNavController(bottomNavigationView,navController)

    }


    // -- Función para iniciar RecyclerView

    /*private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.movieRecycler)
        movieRecycler.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(MovieProvider.movieList)

    }*/

}