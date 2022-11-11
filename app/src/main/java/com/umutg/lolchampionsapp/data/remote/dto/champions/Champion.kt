package com.umutg.lolchampionsapp.data.remote.dto.champions


import com.google.gson.annotations.SerializedName
import com.umutg.lolchampionsapp.domain.model.Champions

data class Champion(
    @SerializedName("blurb")
    val blurb: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("info")
    val info: Info,
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("partype")
    val partype: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("version")
    val version: String
)

fun Champion.toChampionList(): Champions {

    return Champions(
        id = id,
        name = name,
        title = title,
        blurb = blurb,
        image = image.full
    )
}