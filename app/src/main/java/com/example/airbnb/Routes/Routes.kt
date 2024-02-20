package com.example.airbnb.Routes

sealed class Routes(val route: String) {
    object Splash: Routes("SplashScreen")
    object SignUp: Routes("SignUp")
    object Login: Routes("Login")
    object Home: Routes("Home")
    object Profile: Routes("Profile")
    object Search:Routes("Search")
    object EditUserProfile:Routes("EditUserProfile")
    object UploadHouse:Routes("UploadHouse")
}