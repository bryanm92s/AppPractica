package com.example.apppractica.Views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apppractica.MovieAdapter
import com.example.apppractica.Movies
import com.example.apppractica.R
import com.example.apppractica.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_inicio.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController:NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var movielist:ArrayList<Movies>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Instancia del view binding
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movielist=ArrayList()
        addMovies()


        // RecyclerView
        movieRecycler.layoutManager=LinearLayoutManager(this)
        movieRecycler.addItemDecoration(DividerItemDecoration(this,1))
        movieRecycler.adapter= MovieAdapter(movielist)


        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        //navController = navHostFragment.navController
        //val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        //setupWithNavController(bottomNavigationView,navController)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavigationView
        // Sincronización del navController con nuestro bottom navigation
        bottomNavigationView.setupWithNavController(navController)

    }

    fun addMovies(){
        movielist.add(Movies(R.drawable.grinch,"Grinch","2000","Jim Carrey"))
        movielist.add(Movies(R.drawable.spiderman,"SpiderMan","2022","Tom Holland"))
        movielist.add(Movies(R.drawable.encanto,"Encanto","2021","Disney"))
        movielist.add(Movies(R.drawable.morbius,"Morbius","2022","Jared Leto"))
        movielist.add(Movies(R.drawable.sonic2,"Sonic 2","2022","Jim Carrey"))
    }
}