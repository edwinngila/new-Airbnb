package com.example.airbnb.Presentation.Screens.DashboardScreen

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.airbnb.Controlers.AuthViewModel
import com.example.airbnb.Presentation.Components.FormInput
import com.example.airbnb.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditUserProfile(navController: NavController,viewModel: AuthViewModel) {
    val userState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val bioState = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            Column (
                modifier = Modifier
                    .clickable {
                        navController.navigate("Profile")
                    }
            ){
                Image(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription ="Close",
                )
            }

            Column(
                modifier = Modifier.padding(top = 5.dp)
            ){
                Text(
                    text = "Edit Profile",
                    color = Color(0x1F, 0xDF, 0x64),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            }

            Column(
                modifier = Modifier.padding(top = 5.dp)
            ){
                    Text(
                        text = "Save",
                        color = Color.Black
                    )
            }
        }
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = R.drawable.userprofile),
                    contentDescription ="user profile",
                    modifier = Modifier
                        .clickable {
                            navController.navigate("EditUserProfile")
                        }
                        .clip(CircleShape)
                        .padding(top = 30.dp)
                        .size(120.dp)
                )
                Text(
                    text = "Change Profile Photo",
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Column (
                    modifier = Modifier.padding(top = 50.dp)
                ){
                    FormInput(nameState = userState, lable ="User Name" )
                    FormInput(nameState = emailState, lable ="Email" )
                    OutlinedTextField(
                        value = bioState.value,
                        onValueChange = {
                            bioState.value = it
                        },
                        label = {
                                Text(
                                    text = "Bio"
                                )
                        },
                        modifier = Modifier.fillMaxWidth().padding(10.dp).height(120.dp)
                    )
                }
            }
        }
    }
}