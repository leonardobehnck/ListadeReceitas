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
import androidx.compose.ui.tooling.preview.Preview


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DialogScreen(showDialog: MutableState<Boolean>) {
  var title by remember { mutableStateOf("")  }
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



