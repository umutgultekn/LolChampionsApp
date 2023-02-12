package com.umutg.lolchampionsapp.domain.model


import com.google.gson.annotations.SerializedName

data class ChampionSpell(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: SpellImage
)

data class SpellImage(
    @SerializedName("full")
    val full: String,
    @SerializedName("group")
    val group: String,
    @SerializedName("sprite")
    val sprite: String
)