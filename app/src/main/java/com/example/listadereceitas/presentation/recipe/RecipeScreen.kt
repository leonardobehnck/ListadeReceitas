package com.example.listadereceitas.presentation.recipe

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.listadereceitas.routes.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun FirstScreen(navController: NavController) {
  Scaffold {
    Column {
      TopAppBar(
        title = { Text("First Activity") },
        colors = TopAppBarDefaults.smallTopAppBarColors(Color.LightGray),
      )

      Column(
        Modifier
          .fillMaxWidth()
          .weight(1.0f)
          .padding(16.dp)) {
        ButtonSecondActivity(navController)
      }

      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
        horizontalAlignment = Alignment.End
        ) {
        FloatActionButton()
      }
    }
  }
}

@Composable
fun FloatActionButton() {
  FloatingActionButton(
    onClick = { /* do something */ },
    Modifier.absoluteOffset()
  )
  {
    Icon(Icons.Filled.Add, contentDescription = "Localized description")
  }
}

@Composable
fun ButtonSecondActivity(navController: NavController) {
  Button(
    onClick = {
      navController.navigate(Routes.SecondScreen)
    },
  ) {
    Text(text = "Avançar")
  }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  val navController = rememberNavController()
  FirstScreen(navController)
}






