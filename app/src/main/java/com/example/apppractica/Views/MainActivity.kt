package com.example.apppractica.Views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.apppractica.R
import com.example.apppractica.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController:NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Instancia del view binding
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        //navController = navHostFragment.navController
        //val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        //setupWithNavController(bottomNavigationView,navController)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavigationView
        // Sincronizacion del navController con nuesto bottom navigation
        bottomNavigationView.setupWithNavController(navController)

    }
}