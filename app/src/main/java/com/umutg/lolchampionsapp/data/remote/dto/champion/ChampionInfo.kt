package com.umutg.lolchampionsapp.data.remote.dto.champion


import com.google.gson.annotations.SerializedName
import com.umutg.lolchampionsapp.domain.model.Champion

data class ChampionInfo(
    @SerializedName("allytips")
    val allytips: List<String>,
    @SerializedName("blurb")
    val blurb: String,
    @SerializedName("enemytips")
    val enemytips: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("info")
    val info: Info,
    @SerializedName("key")
    val key: String,
    @SerializedName("lore")
    val lore: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("partype")
    val partype: String,
    @SerializedName("passive")
    val passive: Passive,
    @SerializedName("recommended")
    val recommended: List<Any>,
    @SerializedName("skins")
    val skins: List<Skin>,
    @SerializedName("spells")
    val spells: List<Spell>,
    @SerializedName("stats")
    val stats: Stats,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("title")
    val title: String
)


fun ChampionInfo.toChampion(): Champion {
    return Champion(
        name = name,
        description = "",
        lore = lore,
        blurb = blurb,
        championSpell = null
    )
}