package com.example.airbnb.data

data class UserData(
    var userId: String? = null,
    var name: String? = null,
    var username: String? = null,
    var imageUrl: String? = null,
    var bio: String? = null,
    var role:List<Roles>? = null,
    var services: List<String>? = null
){
  fun toMap()= mapOf(
      "userId" to userId,
      "name" to name,
      "username" to username,
      "imageUrl" to imageUrl,
      "bio" to bio,
  )
}