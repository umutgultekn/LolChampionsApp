package com.umutg.lolchampionsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Champions(
    val id: String,
    val name: String,
    val title: String,
    val blurb: String,
    val image: String
) : Parcelable