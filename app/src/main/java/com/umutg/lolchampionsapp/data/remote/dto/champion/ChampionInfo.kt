package com.umutg.lolchampionsapp.data.remote.dto.champion


import com.google.gson.annotations.SerializedName
import com.umutg.lolchampionsapp.domain.model.Champion

data class ChampionInfo(

    @SerializedName("blurb")
    val blurb: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("lore")
    val lore: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("passive")
    val passive: Passive,
    @SerializedName("recommended")
    val recommended: List<Any>,
    @SerializedName("spells")
    val spells: List<Spell>,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("title")
    val title: String
)


fun ChampionInfo.toChampion(): Champion {
    return Champion(
        id = id,
        name = name,
        title = "",
        lore = lore,
        blurb = blurb,
        image = image.full,
        championSpell = spells.map { it.toChampionSpell() }
    )
}