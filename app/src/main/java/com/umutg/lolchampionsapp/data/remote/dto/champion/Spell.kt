package com.umutg.lolchampionsapp.data.remote.dto.champion


import com.google.gson.annotations.SerializedName
import com.umutg.lolchampionsapp.domain.model.ChampionSpell

data class Spell(
    @SerializedName("id")
    val id: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("name")
    val name: String,

    )


fun Spell.toChampionSpell(): ChampionSpell {
    return ChampionSpell(
        id = id,
        name = name,
        description = description,
        image = image.toChampionImage()
    )
}