package com.example.listadereceitas.presentation.dialog

import android.annotation.SuppressLint
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.listadereceitas.domain.model.RecipeDomain
import com.example.listadereceitas.presentation.recipe.RecipeViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DialogScreen(showDialog: MutableState<Boolean>) {
  val viewModel: RecipeViewModel = viewModel(factory = RecipeViewModel.Factory())
  var title by remember { mutableStateOf("") }

  var listRecipes : List<String> = listOf("Pudim", "Nega Maluca", "Lasanha")

  AlertDialog(
    title = {
      Text(text = "Adicione uma receita")
    },
    text = {
      OutlinedTextField(
        value = title,
        onValueChange = { title = it },
        label = { Text("Insira um titulo:") }
      )
    },
    onDismissRequest = {
      showDialog.value = false
    },
    confirmButton = {
      TextButton(
        onClick = {
          showDialog.value = false

          //Insert in  DB, need to make the list in screen
          viewModel.insert(title)

        }
      ) {
        Text("Confirm")
      }
    },
    dismissButton = {
      TextButton(
        onClick = {
          showDialog.value = false
        }
      ) {
        Text("Dismiss")
      }
    }
  )
}


@Preview
@Composable
fun Preview() {
  //DialogScreen()
}



