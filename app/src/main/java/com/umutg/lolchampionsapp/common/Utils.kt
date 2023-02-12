package com.umutg.lolchampionsapp.common

object Utils {

    fun convertImageUrl(image: String): String {
        return Constants.CHAMPIONS_IMAGE_URL + image
    }

    fun convertChampionDetailsImageUrl(image: String): String {
        return Constants.CHAMPIONS_DETAIL_IMAGE_URL + image + "_0.jpg"
    }

    fun convertChampionSpellImageUrl(image: String): String {
        return Constants.CHAMPIONS_DETAIL_SPELL_IMAGE_URL + image
    }
}