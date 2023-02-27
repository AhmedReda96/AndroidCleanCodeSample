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

