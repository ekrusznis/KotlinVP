package uw.ek.kotlinvp.utils

import android.content.Context
import android.content.SharedPreferences
import android.graphics.drawable.Drawable

class SharedPreference(val context: Context) {
    private val PREFS_NAME = "checkout"
    val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)


    fun save(KEY_NAME: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_NAME, value)
        editor.apply()
    }

    fun save(KEY_NAME: String, value: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(KEY_NAME, value)
        editor.apply()
    }

    fun save(KEY_NAME: String, status: Boolean) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(KEY_NAME, status!!)
        editor.apply()
    }
}