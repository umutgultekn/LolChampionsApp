package com.umutg.lolchampionsapp.data.remote.dto.champion


import com.google.gson.annotations.SerializedName

data class Spell(
    @SerializedName("cooldown")
    val cooldown: List<Double>,
    @SerializedName("cooldownBurn")
    val cooldownBurn: String,
    @SerializedName("cost")
    val cost: List<Int>,
    @SerializedName("costBurn")
    val costBurn: String,
    @SerializedName("costType")
    val costType: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("effect")
    val effect: List<List<Int>>,
    @SerializedName("effectBurn")
    val effectBurn: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("leveltip")
    val leveltip: Leveltip,
    @SerializedName("maxammo")
    val maxammo: String,
    @SerializedName("maxrank")
    val maxrank: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("range")
    val range: List<Int>,
    @SerializedName("rangeBurn")
    val rangeBurn: String,
    @SerializedName("resource")
    val resource: String,
    @SerializedName("tooltip")
    val tooltip: String,
    @SerializedName("vars")
    val vars: List<Any>
)