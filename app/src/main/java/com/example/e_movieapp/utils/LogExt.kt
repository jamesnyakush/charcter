package com.example.e_movieapp.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.e_movieapp.BuildConfig

/*
* Showing Vibility
* */
fun View.show() {
    visibility = View.VISIBLE
}

/*
* Hiding Vibility
* */
fun View.hide() {
    visibility = View.GONE
}

fun Context.toast(message : String){
    Toast.makeText(applicationContext,message, Toast.LENGTH_LONG).apply {
        show()
    }
}

/** Logs Info */
fun String?.logInfo(tag: String = "MatchCardsLog") {
    if (BuildConfig.DEBUG) {
        Log.i(tag, this.toString())
    }
}

/** Logs Error */
fun String?.logError(tag: String = "MatchCardsLog") {
    if (BuildConfig.DEBUG) {
        Log.e(tag, this.toString())
    }
}

/** Logs Debug */
fun String?.logDebug(tag: String = "MatchCardsLog") {
    if (BuildConfig.DEBUG) {
        Log.d(tag, this.toString())
    }
}

/** Logs Wtf */
fun String?.logWtf(tag: String = "MatchCardsLog") {
    if (BuildConfig.DEBUG) {
        Log.wtf(tag, this.toString())
    }
}