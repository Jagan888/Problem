package com.example.food_ordering_app

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {

        const val USER_TOKEN = "user_token"
        const val User_ID="user_id"
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String?=null) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }
    fun saveUserID(ID:String?=null){
        val editor=prefs.edit()
        editor.putString(User_ID,ID)
        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String?{

        return prefs.getString(USER_TOKEN,null)
    }
    fun FetchUserID():String?{
        return prefs.getString(User_ID,null)
    }
}