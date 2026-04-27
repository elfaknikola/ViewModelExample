package com.example.viewmodelexample.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodelexample.ui.MyViewModel

@Composable
fun SecondScreen(stateToDisplay: Boolean, changeState: () -> Unit ,navigateBack: () -> Unit) {

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface) {
        Column(modifier = Modifier
            .padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SecondStateDisplay(stateToDisplay)

            Button(onClick = changeState) {
                Text(text = "Click for state change")
            }

            Spacer(modifier = Modifier.weight(1f))
            ElevatedButton(onClick = navigateBack) {
                Text(text = "Navigate to back to first screen")
            }
        }
    }
}

@Composable
fun SecondStateDisplay(secondState: Boolean = false) {
    Surface {
        Text(text = "Drugo stanje je $secondState")
    }
}