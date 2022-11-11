package com.umutg.lolchampionsapp.data.remote.dto.champion


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("attack")
    val attack: Int,
    @SerializedName("defense")
    val defense: Int,
    @SerializedName("difficulty")
    val difficulty: Int,
    @SerializedName("magic")
    val magic: Int
)