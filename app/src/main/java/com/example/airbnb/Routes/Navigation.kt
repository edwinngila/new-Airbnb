package com.example.airbnb.Routes

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.airbnb.Controlers.AuthViewModel
import com.example.airbnb.Controlers.GetUserHouseViewModel
import com.example.airbnb.Controlers.UploadHouseViewModel
import com.example.airbnb.Presentation.Components.NotificationMessage
import com.example.airbnb.Presentation.Components.ProgressSpinner
import com.example.airbnb.Presentation.Screens.AuthScreen.LoginForm
import com.example.airbnb.Presentation.Screens.AuthScreen.SignUpForms
import com.example.airbnb.Presentation.Screens.DashboardScreen.EditUserProfile
import com.example.airbnb.Presentation.Screens.DashboardScreen.HomeScreen
import com.example.airbnb.Presentation.Screens.DashboardScreen.SearchScreen
import com.example.airbnb.Presentation.Screens.DashboardScreen.UploadMusic
import com.example.airbnb.Presentation.Screens.DashboardScreen.UserProfile
import com.example.airbnb.Presentation.Screens.SplashScreen.FirstScreen

@Composable
fun OnDemandRoutes() {
    val vm: AuthViewModel = hiltViewModel()
    val vm2: UploadHouseViewModel = hiltViewModel()
    val getUserMusicvm: GetUserHouseViewModel= hiltViewModel()
    val navController = rememberNavController()
    ProgressSpinner()
    NotificationMessage(vm = vm)
    NavHost(navController = navController, startDestination = Routes.Splash.route ) {
        composable(Routes.Splash.route){ FirstScreen(navController) }
        composable(Routes.SignUp.route){ SignUpForms(navController,vm) }
        composable(Routes.Login.route){ LoginForm(navController,vm) }

        composable(Routes.Home.route){ HomeScreen(navController,vm,getUserMusicvm)}
        composable(Routes.Profile.route){ UserProfile(navController,vm) }
        composable(Routes.Search.route){ SearchScreen(navController,vm)}
        composable(Routes.EditUserProfile.route){ EditUserProfile(navController,vm)}
        composable(Routes.UploadHouse.route){ UploadMusic(navController,vm2)}
    }
}