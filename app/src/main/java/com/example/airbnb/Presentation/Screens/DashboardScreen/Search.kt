package com.example.airbnb.Presentation.Screens.DashboardScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.airbnb.Controlers.AuthViewModel
import com.example.airbnb.Presentation.Components.BottomNavigationItem
import com.example.airbnb.Presentation.Components.BottomNavigationMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController,viewModel: AuthViewModel) {
    val serchState = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0x12, 0x12, 0x12)) ,
                title = {
                    OutlinedTextField(
                        value = serchState.value,
                        onValueChange = {
                            serchState.value = it
                        },
                        leadingIcon = {
                           Icon(
                               imageVector = Icons.Filled.Search,
                               contentDescription = "Search icon"
                           )
                        },
                        label = {
                            Text(
                                text = "search"
                            )
                        },
                        placeholder = {
                             Text(text = "Search")
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedLabelColor = Color.White,
                            unfocusedBorderColor = Color.Transparent,
                            focusedLabelColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                },
            )
        },
        bottomBar = {
            BottomNavigationMenu(
                selectedItem = BottomNavigationItem.SEARCH,
                navController = navController,
            )
        }
    ) {innerPadding ->
       Column (
           modifier = Modifier
               .padding(innerPadding)
               .padding(top = 10.dp)
               .fillMaxSize()
               .verticalScroll(rememberScrollState())
               .background(Color(0x12, 0x12, 0x12)),
           verticalArrangement = Arrangement.spacedBy(16.dp),
       ){
           Row (
               modifier = Modifier.padding(top = 10.dp)
           ){
               Column (
                   modifier = Modifier.padding(1.dp)
               ){
                   com.example.airbnb.Presentation.Components.AlbumCard()
               }
               Column (
                   modifier = Modifier.padding(1.dp)
               ){
                   com.example.airbnb.Presentation.Components.AlbumCard()
               }
           }
           Row {
               Column (
                   modifier = Modifier.padding(1.dp)
               ){
                   com.example.airbnb.Presentation.Components.AlbumCard()
               }
               Column (
                   modifier = Modifier.padding(1.dp)
               ){
                   com.example.airbnb.Presentation.Components.AlbumCard()
               }
           }
           Row {
               Column (
                   modifier = Modifier.padding(1.dp)
               ){
                   com.example.airbnb.Presentation.Components.AlbumCard()
               }
               Column (
                   modifier = Modifier.padding(1.dp)
               ){
                   com.example.airbnb.Presentation.Components.AlbumCard()
               }
           }
           Row {
               Column (
                   modifier = Modifier.padding(1.dp)
               ){
                   com.example.airbnb.Presentation.Components.AlbumCard()
               }
               Column (
                   modifier = Modifier.padding(1.dp)
               ){
                   com.example.airbnb.Presentation.Components.AlbumCard()
               }
           }
       }
    }
}

