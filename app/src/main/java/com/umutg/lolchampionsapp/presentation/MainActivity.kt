package com.umutg.lolchampionsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.umutg.lolchampionsapp.R
import com.umutg.lolchampionsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        navController = findNavController(R.id.nav_host_fragment)
//        binding.bottomNav.setupWithNavController(navController)
//
//
////        val appBarConfiguration = AppBarConfiguration(
////            setOf(
////                R.id.championsFragment,
////                R.id.favoriteChampionsFragment,
////            )
////        )
//
//        setupActionBarWithNavController(navController)

        val navController = findNavController(R.id.nav_host_fragment)

        setupBottomNavMenu(navController)

    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            android.R.id.home -> {
//                navController.navigateUp()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//    }

//    override fun onBackPressed() {
//        navController.previousBackStackEntry?.let {
//            val destinationFragment = it.destination.id
////            if (childFragmentList.contains(destinationFragment)){
////                navView.menu[childFragmentMenuList[childFragmentList.indexOf(destinationFragment)]].isChecked = true
////            }
//        }
//
//        super.onBackPressed()
//    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav?.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment)) || super.onOptionsItemSelected(
            item
        )
    }

}