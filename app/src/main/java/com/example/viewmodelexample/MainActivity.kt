package com.example.viewmodelexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.viewmodelexample.ui.MyViewModel
import com.example.viewmodelexample.ui.screen.SecondScreen
import com.example.viewmodelexample.ui.screen.ViewModelFirstScreen
import com.example.viewmodelexample.ui.theme.ViewModelExampleTheme

class MainActivity : ComponentActivity() {
    val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VMApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun VMApp(viewModel: MyViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.FirstScreen.name) {
        composable(Screens.FirstScreen.name) {
            val secondState = viewModel.secondState.value
            ViewModelFirstScreen(stateToDisplay = secondState, changeState = { viewModel.changeFirstState() },navigateToSecondScreen = {
                navController.navigate(
                    Screens.SecondScreen.name
                )
            })
        }
        composable(Screens.SecondScreen.name) {
            val firstState by viewModel.firstState.collectAsState()

            SecondScreen(stateToDisplay = firstState, changeState = { viewModel.changeSecondState() } ,navigateBack = { navController.popBackStack() })
        }
    }
}

enum class Screens {
    FirstScreen,
    SecondScreen
}

/*
* TODO: implementirati aplikaciju sa dva ekrana, gde je iz jednog moguce
*  izmeniti jedan deo state-a a prikazati drugi, a u drugom ekranu moguce
*  izmeniti drugi deo state-a a prikazati prvi. Aplikacija treba da sacuva
*  state pri rotaciji ekrana. Implementirati odgovarajucu navigaciju.
* */