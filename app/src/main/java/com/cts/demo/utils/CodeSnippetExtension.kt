package com.cts.demo.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Build

class CodeSnippetExtension private constructor() {

    companion object {
        var appContext: Context? = null
        @Volatile
        private var INSTANCE: CodeSnippetExtension? = null

        fun init(context: Context) {
            appContext = context
        }

        fun getInstance(): CodeSnippetExtension =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: CodeSnippetExtension().also { INSTANCE = it }
            }

    }

    fun isNetworkActive(): Boolean {
        if (appContext == null) {
            return false
        }
        val connectivityManager =
            appContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    fun getVersionCode(context: Context): Long {
        var versionCode = 0L
        try {
            val pInfo: PackageInfo =
                context.getPackageManager().getPackageInfo(context.packageName, 0)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                versionCode = pInfo.longVersionCode
            } else {
                versionCode = pInfo.versionCode.toLong()
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return versionCode
    }

}