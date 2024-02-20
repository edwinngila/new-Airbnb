package com.example.airbnb.Controlers

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbnb.CommonTB.USERMUSIC
import com.example.airbnb.data.Event
import com.example.airbnb.data.UserHouse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class UploadHouseViewModel @Inject constructor(
    val auth: FirebaseAuth,
    val db : FirebaseFirestore,
    val storage: FirebaseStorage
):ViewModel(){
    val popupNotification = mutableStateOf<Event<String>?>(null)
    val inProgress = mutableStateOf(false)
    val userHouse = mutableStateOf<UserHouse?>(null)

    var userMusicImg = mutableStateOf<String?>(null)

    private fun uploadMusicImage(uri :Uri,onSuccess: (Uri) -> Unit) {
        inProgress.value=true
       val storageRef = storage.reference
       val uuid = UUID.randomUUID()
       val audioRef = storageRef.child("image/$uuid")
       val uploadTask = audioRef.putFile(uri)

       uploadTask
           .addOnSuccessListener {
               viewModelScope.launch (Dispatchers.IO){
                   try {
                       val downloadUrl = getDownloadUrl(it.metadata?.reference!!)
                       onSuccess(downloadUrl)
                   } catch (e: Exception) {
                       notification(message = "Error getting download URL")
                   } finally {
                       inProgress.value = false
                   }
               }
           }
           .addOnFailureListener {
               notification(message = "Something went wrong")
           }
   }
    private fun notification(message:String){
        popupNotification.value=Event(message)
    }
    private suspend fun getDownloadUrl(reference: StorageReference): Uri {
        return reference.downloadUrl.await()
    }
    private fun createAudio(
        uid: String?=null,
        name: String?=null,
        description: String?=null,
        musicImg:  MutableState<String?>
    ){
        val uid = auth.currentUser?.uid
        val audioFile = UserHouse(
            uid = uid,
            name = name,
            description = description,
            musicImg = musicImg.value
        )
        uid?.let { uid ->
            inProgress.value = true
            db.collection(USERMUSIC).add(audioFile.toMap()).addOnSuccessListener{
                inProgress.value = false
                popupNotification.value = Event("Audio uploaded successfully")
            }.addOnFailureListener {
                inProgress.value = false
                popupNotification.value = Event("Something went wrong")
            }
        }

    }
    fun saveAudioImg(uri: Uri){
        uploadMusicImage(uri){audioImage->
            userMusicImg.value = audioImage.toString()
            Log.d("TAG", "saveAudioImg: ${userMusicImg.value}")
        }
    }
    fun saveAudioInfo(HouseName:String,Description:String,){
        Log.d("TAG", "Description: ${Description}")
        createAudio(
            name = HouseName,
            description = Description,
            musicImg= userMusicImg
        )
    }
    fun handleException(exception: Exception? = null, customMessage: String = "") {
        exception?.printStackTrace()
        val errorMsg = exception?.localizedMessage ?: ""
        val message = if (customMessage.isEmpty()) errorMsg else "$customMessage: $errorMsg"
        popupNotification.value = Event(message)
    }
}