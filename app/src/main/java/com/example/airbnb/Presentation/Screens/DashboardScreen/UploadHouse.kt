package com.example.airbnb.Presentation.Screens.DashboardScreen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.airbnb.Controlers.UploadHouseViewModel
import com.example.airbnb.Presentation.Components.BottomNavigationItem
import com.example.airbnb.Presentation.Components.BottomNavigationMenu
import com.example.airbnb.Presentation.Components.FormInput
import com.example.airbnb.Presentation.Components.ProgressSpinner
import com.example.airbnb.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadMusic(navController: NavController, viewModel: UploadHouseViewModel) {
    val HouseName = remember { mutableStateOf("") }
    val Discription = remember { mutableStateOf("") }
    val Location = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold (
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState){
                Snackbar(
                    snackbarData = it,
                    containerColor = Color(0xFF626B74),
                    contentColor = Color.White,
                    actionColor = Color(255, 56, 92)
                )
            }
        },
        bottomBar = {
            BottomNavigationMenu(
                selectedItem = BottomNavigationItem.UPLOADHOUSE,
                navController = navController
            )
        }
    ){innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.White)
                .fillMaxSize()
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ){
                Image(
                    painter = painterResource(id = R.drawable.airbnblogo),
                    contentDescription ="Logo",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
            }
            Column (
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
            ){
                Text(
                    text = "Upload your home",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp,
                    color = Color.Black
                )
                Text(
                    text = "Let people see what you have to offer",
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
            Column {
                FormInput(nameState =HouseName, lable ="Name" )
                FormInput(nameState =Location, lable ="Location" )
                OutlinedTextField(
                    value = Discription.value,
                    onValueChange = {
                        Discription.value = it
                    },
                    label = {
                        Text(
                            text = "Description"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .height(120.dp)
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    val launcher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.GetContent()
                    ) {uri: Uri? ->
                        uri?.let {
                            if (uri !=null){
                                viewModel.saveAudioImg(
                                    uri=uri,
                                )
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "File has been uploaded",
                                        actionLabel = "Ok"
                                    )
                                }
                            }
                            else{
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Please select a file",
                                        actionLabel = "Ok",
                                    )
                                }
                            }
                        }
                    }
                    Button(
                        onClick = {launcher.launch("image/*")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(255, 56, 92)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(255, 56, 92),
                            contentColor = Color.White
                        ),

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.imagegallery),
                                contentDescription ="Upload"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Upload House Image",
                                modifier = Modifier.padding(top =5.dp)
                            )
                        }
                    }
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    Button(
                        onClick = {
                            viewModel.saveAudioInfo(
                                    HouseName = HouseName.value,
                                    Description = Discription.value,
                            )
                            navController.navigate("Home")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(255, 56, 92)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(255, 56, 92),
                            contentColor = Color.White
                        ),

                    ) {
                        Text(text = "Save new Home")
                    }
                }
            }
        }
    }
    var inprogress = viewModel.inProgress.value
    if (inprogress){
        ProgressSpinner()
    }
}