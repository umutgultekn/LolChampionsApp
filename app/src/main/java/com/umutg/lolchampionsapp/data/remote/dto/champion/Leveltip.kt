package com.umutg.lolchampionsapp.data.remote.dto.champion


import com.google.gson.annotations.SerializedName

data class Leveltip(
    @SerializedName("effect")
    val effect: List<String>,
    @SerializedName("label")
    val label: List<String>
)