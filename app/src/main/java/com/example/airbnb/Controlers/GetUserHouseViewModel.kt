package com.example.airbnb.Controlers

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbnb.data.UserHouse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class GetUserHouseViewModel @Inject constructor(
    val auth: FirebaseAuth,
    val db: FirebaseFirestore,
    val storage: FirebaseStorage
) : ViewModel() {
        val state = mutableStateOf<List<UserHouse>>(emptyList())
        val inProgress = mutableStateOf(false)
    init{
        getData()
    }
    private fun getData(){
        viewModelScope.launch {
            state.value= getDataFromFireStore()
        }
    }
    suspend fun getDataFromFireStore(): List<UserHouse> {
        val userMusicList = mutableListOf<UserHouse>()
        try {
            val querySnapshot = db.collection("userMusic").get().await()
            for (document in querySnapshot) {
                val result = document.toObject(UserHouse::class.java)
                userMusicList.add(result)
            }
        } catch (e: FirebaseFirestoreException) {
            Log.d("error", "getDataFromFireStore: $e")
        }
        return userMusicList
    }
}