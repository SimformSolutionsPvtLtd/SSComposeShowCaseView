package com.example.sscomposeshowcaseview

import android.content.Context
import android.content.SharedPreferences

class Preferences(private val context: Context) {

    fun show(key: String) {
        val preferences: SharedPreferences = context.getSharedPreferences(SHOWCASE_VIEW_JETPACK, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putBoolean(key, true)
        editor.apply()
    }

    fun getShowing(key: String): Boolean {
        val preferences: SharedPreferences = context.getSharedPreferences(SHOWCASE_VIEW_JETPACK, Context.MODE_PRIVATE)
        return preferences.getBoolean(key, false)
    }

    companion object {
        const val SHOWCASE_VIEW_JETPACK = "SHOWCASE_VIEW_JETPACK"
    }

}