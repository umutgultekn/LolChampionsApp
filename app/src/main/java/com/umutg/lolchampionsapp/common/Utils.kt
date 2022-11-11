package com.umutg.lolchampionsapp.common

object Utils {

    fun convertImageUrl(image: String): String {
        return Constants.CHAMPIONS_IMAGE_URL + image
    }
}