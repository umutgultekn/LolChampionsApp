package com.umutg.lolchampionsapp.data.remote.dto.champion


import com.google.gson.annotations.SerializedName
import com.umutg.lolchampionsapp.domain.model.SpellImage

data class Image(
    @SerializedName("full")
    val full: String,
    @SerializedName("group")
    val group: String,
    @SerializedName("sprite")
    val sprite: String,

    )

fun Image.toChampionImage(): SpellImage {
    return SpellImage(
        full = full,
        group = group,
        sprite = sprite
    )
}