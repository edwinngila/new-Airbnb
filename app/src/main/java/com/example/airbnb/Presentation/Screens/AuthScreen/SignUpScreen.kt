package com.example.airbnb.Presentation.Screens.AuthScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.airbnb.R
import com.example.airbnb.Controlers.AuthViewModel
import com.example.airbnb.Presentation.Components.FormInput

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpForms(navController: NavController,viewModel: AuthViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val userNameState = remember { mutableStateOf("") }
        val emailState = remember { mutableStateOf("") }
        val passwordState = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.airbnblogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
            ){
                Text(
                    text = "Create an account",
                    fontSize = 36.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
            ){
                Text(
                    text = "Welcome! Pleace enter your details",
                    fontSize = 17.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                FormInput(nameState = userNameState, lable = "User Name")
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                FormInput(nameState = emailState, lable ="Email")
            }
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                FormInput(nameState = passwordState, lable = "Password")

            }
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Password should have 8 characters, one symble,one uppercasse letter and one number",
                    fontSize = 13.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {
                              viewModel.registerUser(
                                  userName = userNameState.value,
                                  email = emailState.value,
                                  pass = passwordState.value,
                                  navController = navController
                              )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor =  Color(255, 56, 92),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .background(
                            color =  Color(255, 56, 92)
                        ),
                ) {
                    Text(
                        text = "Sign Up"
                    )
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom

            ){
                val text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray
                        )
                    ) {
                        append("I Already have an account ")
                    }
                    pushStringAnnotation(
                        tag = "Clickable",
                        annotation = "Log in"
                    )
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    ) {
                        append(" Log in")
                    }
                    pop()
                }

                ClickableText(
                    text = text,
                    onClick = {
                        navController.navigate("Login")
                    }
                )
            }
        }
    }
}