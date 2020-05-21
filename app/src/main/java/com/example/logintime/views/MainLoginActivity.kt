package com.example.logintime.views

import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.logintime.R
import com.google.android.material.navigation.NavigationView

class MainLoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_notice,
                R.id.navigation_chat,
                R.id.navigation_notifications,
                R.id.navigation_calculator))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //ciclo de vida dos fragmentos tem ligacao com o ciclo de vida da activity

        /* val exit:ListView = navView.findViewById(R.id.navigation_exit)
                exit.setOnClickListener {
                    finish()
                }
    */


    }
}

