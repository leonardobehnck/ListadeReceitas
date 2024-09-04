package com.example.listadereceitas.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listadereceitas.presentation.detail.DetailScreen
import com.example.listadereceitas.presentation.recipe.RecipeScreen
import com.example.listadereceitas.presentation.recipe.RecipeState
import com.example.listadereceitas.presentation.recipe.RecipeViewModel
import com.example.listadereceitas.presentation.routes.Routes

class MainActivity : ComponentActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val navController = rememberNavController()
      NavHost(navController = navController, startDestination = Routes.FirstScreen) {
        composable(Routes.FirstScreen) {
          RecipeScreen(navController)
        }
        composable(Routes.SecondScreen) {
          DetailScreen(navController)
        }
      }
    }
  }
}




