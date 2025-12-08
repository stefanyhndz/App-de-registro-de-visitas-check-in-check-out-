package com.example.visitapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.rememberNavController
import com.example.visitapp.data.VisitDatabase
import com.example.visitapp.data.VisitRepository        // <-- usar VisitRepository existente
import com.example.visitapp.ui.VisitsViewModel
import com.example.visitapp.ui.VisitsViewModelFactory
import com.example.visitapp.navigation.AppNavHost

class MainActivity : ComponentActivity() {

    private val repo by lazy {
        val db = VisitDatabase.getDatabase(applicationContext)
        // Usa la clase VisitRepository (la que ya definiste/pegaste antes)
        VisitRepository(db.visitDao())
    }

    private val viewModel: VisitsViewModel by viewModels { VisitsViewModelFactory(repo) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            AppNavHost(navController = navController, viewModel = viewModel)
        }
    }
}
