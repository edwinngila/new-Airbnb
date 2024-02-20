package com.example.airbnb.Presentation.Screens.DashboardScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.airbnb.Controlers.AuthViewModel
import com.example.airbnb.Controlers.GetUserHouseViewModel
import com.example.airbnb.Presentation.Components.BottomNavigationItem
import com.example.airbnb.Presentation.Components.BottomNavigationMenu
import com.example.airbnb.Presentation.Components.HomeComponents
import com.example.airbnb.R
import java.time.LocalTime


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController,viewModel: AuthViewModel,getUserMusicvm: GetUserHouseViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor=Color.White,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                title = {
                    Text(
                        text = TimerLogic(),
                        color = Color(255, 56, 92),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp,
                    )
                },
                actions = {
                    Image(
                        painter = painterResource(id = R.drawable.u),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .padding(10.dp)
                            .width(25.dp)
                            .height(25.dp)
                            .clickable {
                                navController.navigate("Profile")
                            }
                    )
                }
            )
        },
        bottomBar = {
            BottomNavigationMenu(
                selectedItem = BottomNavigationItem.HOME,
                navController = navController,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            HomeComponents(navController,getUserMusicvm)
        }
    }
}

@Composable
fun TimerLogic():String {
    var currentTime: LocalTime = LocalTime.now()
    return when {
        currentTime.isBefore(LocalTime.NOON) -> "Good Morning"
        currentTime.isBefore(LocalTime.of(18, 0)) -> "Good Afternoon"
        else -> "Good Evening"
    }
}