package com.example.airbnb.Presentation.Components

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.airbnb.Controlers.AuthViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationMessage(vm:AuthViewModel) {
    val notifState = vm.popupNotification.value
    val notifMessage = notifState?.getContentOrNull()
    if (notifMessage != null) {
        Toast.makeText(LocalContext.current, notifMessage, Toast.LENGTH_LONG).show()
    }
}