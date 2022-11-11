package com.umutg.lolchampionsapp.data.remote.dto.champions


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("full")
    val full: String,
    @SerializedName("group")
    val group: String,
    @SerializedName("sprite")
    val sprite: String,

    )