package com.example.airbnb.Presentation.Screens.DashboardScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.airbnb.Controlers.AuthViewModel
import com.example.airbnb.Presentation.Components.BottomNavigationItem
import com.example.airbnb.Presentation.Components.BottomNavigationMenu
import com.example.airbnb.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfile(navController: NavController,viewModel: AuthViewModel) {
    Scaffold (
        bottomBar = {
            BottomNavigationMenu(
                selectedItem = BottomNavigationItem.SEARCH,
                navController = navController,
            )
        }
    ){innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ){
           ProfileImg(navController=navController)
        }
    }

}

@Composable
fun UserCardComponent(
    name:String,
    username:String,
    bio:String
) {
    OutlinedCard(
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(width = 600.dp, height = 500.dp)
            .padding(start = 10.dp, end = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.userprofile),
                contentDescription ="user profile",
                modifier = Modifier.clickable {

                }
            )
        }
        Row {
            Text(
                text="Name $name"
            )
            Text(
                text="User Name $username"
            )
            Text(
                text="BIO $bio"
            )
        }
        Text(
            text = "Outlined",
            modifier = Modifier
                .padding(16.dp),
               textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ProfileImg(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.userprofile),
            contentDescription ="user profile",
            modifier = Modifier
                .clickable {
                    navController.navigate("EditUserProfile")
                }
                .clip(CircleShape)
                .size(90.dp)
        )
        Text(
            text = "edwin ngila kyalo",
            modifier = Modifier.padding(top = 30.dp),
            fontSize = 30.sp,
            color = Color.Black
        )
        OutlinedButton(
            onClick = {
                navController.navigate("EditUserProfile")
            },
            modifier = Modifier.padding(top = 10.dp).height(32.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                      contentColor = Color(255, 56, 92),
                      disabledContainerColor = Color(255, 56, 92),
        )
        ) {
            Text(
                text = "Edit profile"
            )
        }
        Column(
            modifier = Modifier.fillMaxSize()
        ){
           Row (
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.Center
           ){
               Text(
                   text ="ENLISTED HOMES",
                   fontSize = 20.sp,
                   textAlign = TextAlign.Center,
                   modifier = Modifier.padding(top=20.dp, bottom = 20.dp),
                   color = Color(255, 56, 92),
                   fontWeight = FontWeight.SemiBold
               )
           }
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription ="Artis img",
                    modifier = Modifier.size(90.dp)
                )
                Column (
                    modifier = Modifier.padding(20.dp)
                ){
                    Text(
                        text = "John stecks",
                        color = Color(255, 56, 92),
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = "33,3333 Music",
                        color = Color(255, 56, 92),
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription ="Artis img",
                    modifier = Modifier.size(90.dp)
                )
                Column (
                    modifier = Modifier.padding(20.dp)
                ){
                    Text(
                        text = "John stecks",
                        color = Color(255, 56, 92),
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = "33,3333 Music",
                        color = Color(255, 56, 92),
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription ="Artis img",
                    modifier = Modifier.size(90.dp)
                )
                Column (
                    modifier = Modifier.padding(20.dp)
                ){
                    Text(
                        text = "John stecks",
                        color = Color(255, 56, 92),
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = "33,3333 Music",
                        color = Color(255, 56, 92),
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription ="Artis img",
                    modifier = Modifier.size(90.dp)
                )
                Column (
                    modifier = Modifier.padding(20.dp)
                ){
                    Text(
                        text = "John stecks",
                        color = Color(255, 56, 92),
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = "33,3333 Music",
                        color = Color(255, 56, 92),
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }
}
