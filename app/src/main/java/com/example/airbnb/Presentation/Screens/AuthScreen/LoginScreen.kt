package com.example.airbnb.Presentation.Screens.AuthScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.airbnb.Controlers.AuthViewModel
import com.example.airbnb.Presentation.Components.AirbnbLogo
import com.example.airbnb.Presentation.Components.FormInput
import com.example.airbnb.R

@Composable
fun LoginForm(navController: NavController,viewModel: AuthViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val emailState = remember { mutableStateOf("") }
        val passwordState = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
//             verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                AirbnbLogo()
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
            ){
                Text(
                    text = "Login in to your account",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Black
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
            ){
                Text(
                    text = "Welcome back! Please enter your details",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(10.dp)
                )
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = {
                              viewModel.loginUser(
                                  email = emailState.value,
                                  pass = passwordState.value,
                                  navController=navController
                              )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(255, 56, 92),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(255, 56, 92)
                        ),
                ) {
                    Text(
                        text = "Login"
                    )
                }
            }
            Row (
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Forgot password?",
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(10.dp)
                )
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
                        append("Don't have an account")
                    }
                    pushStringAnnotation(
                        tag = "Clickable",
                        annotation = "Sign up"
                    )
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                        )
                    ) {
                        append(" Sign up")
                    }
                    pop()
                }

                ClickableText(
                    text = text,
                    onClick = {
                       navController.navigate("SignUp")
                    }
                )
            }

            }
        }
    }

