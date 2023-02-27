package com.example.uctask.utils

import android.util.Log

fun showLog(errorType: Boolean = false, message: String?) {
    if (errorType) Log.i(
        ConstantStrings.TAG,
        " ${ConstantStrings.SHOW_LOG} ${ConstantStrings.ERROR} $message"
    )
    else Log.d(
        ConstantStrings.TAG, " ${ConstantStrings.SHOW_LOG} $message"
    )
}

fun getImageUrl(url: String?): String {
    val pokemonIndex = url?.split("/".toRegex())?.dropLastWhile { it.isEmpty() }?.toTypedArray()
    return "${ConstantStrings.IMAGE_URL}${pokemonIndex?.get(pokemonIndex.size - 1)}.png"
}
