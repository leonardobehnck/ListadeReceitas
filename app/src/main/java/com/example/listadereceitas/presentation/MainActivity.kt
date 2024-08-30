package com.example.listadereceitas.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listadereceitas.routes.Routes

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val navController = rememberNavController()
      NavHost(navController = navController, startDestination = Routes.FirstScreen) {
        composable(Routes.FirstScreen) {
          FirstScreen(navController)
        }
        composable(Routes.SecondScreen) {
          SecondScreen(navController)
        }
      }
    }
  }
}






