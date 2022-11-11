package com.umutg.lolchampionsapp.domain.model


import com.google.gson.annotations.SerializedName

data class ChampionSpell(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("name")
    val name: String,
    @SerializedName("resource")
    val resource: String,
)

data class Image(
    @SerializedName("full")
    val full: String,
    @SerializedName("group")
    val group: String,
    @SerializedName("sprite")
    val sprite: String,

    )