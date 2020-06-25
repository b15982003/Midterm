package com.ray.schoolmidterm

import android.app.Application
import android.content.Context

class Yourapp : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

    }

    companion object {
        lateinit var appContext: Context
    }
}
//shar
object UserManager {
    val prof = Yourapp.appContext.getSharedPreferences(
        "fbToken",
        Context.MODE_PRIVATE
    )

    var token: String?
        get() {
            // read data from sharedperference
            val gettoken = prof.getString("token", null)
            return gettoken
        }
        set(value) {
            // writ data to sharedperference
            val settoken = prof.edit()
            settoken.putString("token", value).apply()

        }

    fun isLogin(): Boolean {
        return token != null
    }
}