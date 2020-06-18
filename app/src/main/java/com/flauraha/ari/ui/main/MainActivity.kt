package com.flauraha.ari.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.flauraha.ari.AriApplication
import com.flauraha.ari.R
import com.flauraha.ari.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    @Inject
    lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as AriApplication).appComponent.userManager().userComponent!!.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.home_dest, R.id.shelves_dest, R.id.account_dest))

        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.mainNavFragment)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavBar.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.mainNavFragment).navigateUp()
}
