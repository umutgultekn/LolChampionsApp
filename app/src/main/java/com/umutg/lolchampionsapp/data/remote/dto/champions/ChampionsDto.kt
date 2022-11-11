package com.umutg.lolchampionsapp.data.remote.dto.champions


import com.google.gson.annotations.SerializedName

data class ChampionsDto(
    @SerializedName("data")
    val `data`: Map<String, Champion>,
    @SerializedName("format")
    val format: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("version")
    val version: String
)