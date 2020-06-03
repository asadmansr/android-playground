package com.asadmansr.navigationapp.core

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(context: Context) {

    private val prefFileName = "com.asadmansr.navigationapp.core"
    private val userAuthKey = "com.asadmansr.navigationapp.core.user.signed_in"
    private val pref: SharedPreferences =
        context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    fun authenticateUser(isSignedIn: Boolean) {
        val editor = pref.edit()
        editor.putBoolean(userAuthKey, isSignedIn)
        editor.apply()
    }

    fun isUserSignedIn(): Boolean {
        return pref.getBoolean(userAuthKey, false)
    }

}