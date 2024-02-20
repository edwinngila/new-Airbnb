package com.example.airbnb.data

data class UserHouse (
    var uid: String? = null,
    var name: String? = null,
    var description: String? = null,
    var musicImg: String? = null,
){
    fun toMap()= mapOf(
        "uid" to uid,
        "name" to name,
        "description" to description,
        "musicImg" to musicImg,
    )
}