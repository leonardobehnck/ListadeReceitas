package com.example.listadereceitas.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.example.listadereceitas.presentation.routes.Routes


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  fun DetailScreen(navController: NavController) {
    Scaffold {
      Column {
        TopAppBar(
          title = { Text("Second Activity") },
          colors = TopAppBarDefaults.smallTopAppBarColors(Color.LightGray),
          navigationIcon = {
            IconButton(onClick = {
              navController.navigate(Routes.FirstScreen, navOptions {
                popUpTo("main") {
                  inclusive = true
                }
              })
            }) {
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Localized description"
              )
            }
          },
        )
      }
    }
  }

  @Preview
  @Composable
  fun Preview() {
    //SecondScreen()
  }


