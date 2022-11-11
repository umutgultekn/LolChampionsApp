package com.umutg.lolchampionsapp.data.remote.dto.champion


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("armor")
    val armor: Double,
    @SerializedName("armorperlevel")
    val armorperlevel: Double,
    @SerializedName("attackdamage")
    val attackdamage: Double,
    @SerializedName("attackdamageperlevel")
    val attackdamageperlevel: Double,
    @SerializedName("attackrange")
    val attackrange: Double,
    @SerializedName("attackspeed")
    val attackspeed: Double,
    @SerializedName("attackspeedperlevel")
    val attackspeedperlevel: Double,
    @SerializedName("crit")
    val crit: Double,
    @SerializedName("critperlevel")
    val critperlevel: Double,
    @SerializedName("hp")
    val hp: Double,
    @SerializedName("hpperlevel")
    val hpperlevel: Double,
    @SerializedName("hpregen")
    val hpregen: Double,
    @SerializedName("hpregenperlevel")
    val hpregenperlevel: Double,
    @SerializedName("movespeed")
    val movespeed: Double,
    @SerializedName("mp")
    val mp: Double,
    @SerializedName("mpperlevel")
    val mpperlevel: Double,
    @SerializedName("mpregen")
    val mpregen: Double,
    @SerializedName("mpregenperlevel")
    val mpregenperlevel: Double,
    @SerializedName("spellblock")
    val spellblock: Double,
    @SerializedName("spellblockperlevel")
    val spellblockperlevel: Double
)