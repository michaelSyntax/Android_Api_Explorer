package com.example.android_base_starter

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.android_base_starter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.bottomNav.setupWithNavController(navHost.navController)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mockFragment -> {
                    navHost.navController.navigate(R.id.mockFragment)
                }
                R.id.googleFragment -> {
                    navHost.navController.navigate(R.id.googleFragment)
                }
                R.id.OAuthFragment-> {
                    navHost.navController.navigate(R.id.OAuthFragment)
                }
            }

            return@setOnItemSelectedListener true
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                binding.navHostFragment.findNavController().navigateUp()
            }
        }
        onBackPressedDispatcher.addCallback(callback)
    }
}