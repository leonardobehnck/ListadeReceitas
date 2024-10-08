package com.example.listadereceitas.presentation.recipe

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.listadereceitas.domain.model.RecipeDomain
import com.example.listadereceitas.presentation.dialog.DialogScreen
import com.example.listadereceitas.presentation.routes.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun RecipeScreen(navController: NavController) {
  val viewModel: RecipeViewModel = viewModel(factory = RecipeViewModel.Factory())
  var listRecipes : List<String> = listOf("Pudim", "Nega Maluca", "Lasanha")

  val context = LocalContext.current
  var progressBarVisibility = false


  viewModel.state.observeForever { state ->
    when (state) {
      is RecipeState.Loading -> {
        //progressBarVisibility = true
      }

      RecipeState.Empty -> {
        Toast.makeText(context, "Ops, insira um titulo válido.", Toast.LENGTH_SHORT).show()
      }

      is RecipeState.Error -> {
        progressBarVisibility = false
      }

      is RecipeState.Success -> {
        progressBarVisibility = false
      }
    }
  }

  Scaffold {
    Column {
      TopAppBar(
        title = {
          Text("First Activity")

        })

      Column(
        Modifier
          .fillMaxWidth()
          .weight(1.0f)
          .padding(16.dp)
      ) {

        ProgressBar(visible = progressBarVisibility)
        LazyColumn {
          items(listRecipes.size) { item ->
            RecipeCard(name = listRecipes[item])
          }
        }
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
fun RecipeCard(name: String) {
  Card(
    Modifier
      .fillMaxWidth()
      .padding(8.dp)
      .height(80.dp)
  ) {
    Text(
      modifier = Modifier.padding(16.dp),
      text = name,
    )
  }
}


@Composable
fun FloatActionButton() {

  val showDialog: MutableState<Boolean> = remember { mutableStateOf(false) }

  if (showDialog.value) {
    DialogScreen(showDialog)
  }

  FloatingActionButton(
    onClick = { showDialog.value = true },
    Modifier.absoluteOffset()
  )
  {
    Icon(Icons.Filled.Add, contentDescription = "Localized description")
  }
}

@Composable
fun ProgressBar(
  visible: Boolean = false,
) {

  if (visible) {
    CircularProgressIndicator(
      modifier = Modifier.width(32.dp),
      color = MaterialTheme.colorScheme.secondary,
      trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
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
fun Preview() {
  val navController = rememberNavController()
  RecipeScreen(navController)
}









