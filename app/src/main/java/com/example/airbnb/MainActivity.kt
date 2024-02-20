package com.example.airbnb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.airbnb.Presentation.ui.theme.ClassWorkTheme
import com.example.airbnb.Controlers.AuthViewModel
import com.example.airbnb.Presentation.Screens.AuthScreen.LoginForm
import com.example.airbnb.Presentation.Screens.AuthScreen.SignUpForms
import com.example.airbnb.Presentation.Screens.SplashScreen.FirstScreen
import com.example.airbnb.Routes.OnDemandRoutes
import com.example.airbnb.Routes.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassWorkTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    OnDemandRoutes()
                }
            }
        }
    }
}

@Composable
fun OnDemandRoutes() {
    val vm: AuthViewModel = hiltViewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Splash.route ) {
        composable(Routes.Splash.route){ FirstScreen(navController) }
        composable(Routes.SignUp.route){ SignUpForms(navController,vm) }
        composable(Routes.Login.route){ LoginForm(navController,vm) }
    }
}