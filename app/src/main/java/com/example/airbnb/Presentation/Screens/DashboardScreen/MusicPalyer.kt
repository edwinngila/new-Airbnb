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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import com.example.airbnb.R


@Composable
fun MusicPayer(navController: NavController,albumName:Any) {
    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context).build()
    val musicString = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

    val mediaSource = remember(musicString) {
        androidx.media3.common.MediaItem.fromUri(musicString)
    }
    LaunchedEffect(mediaSource){
        exoPlayer.setMediaItem(mediaSource)
        exoPlayer.prepare()
    }
    DisposableEffect(Unit){
        onDispose{
            exoPlayer.release()
        }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ){
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "back",
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("Home")
                    }
            )
        }
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "image",
                modifier = Modifier
                    .size(300.dp)
                    .padding(top = 30.dp)
            )
        }
        Column (
            modifier = Modifier.padding(bottom =20.dp)
        ){
            Text(
                text = "Song Name",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0x1F, 0xDF, 0x64),
                modifier = Modifier.padding(10.dp)
                    .padding(top = 30.dp)
            )
            Text(
                text = "Artist Name",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        AndroidView(
            factory = {
                    ctx->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    setBackgroundColor(Color(0x12, 0x12, 0x12).toArgb())

                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
        )
    }

}