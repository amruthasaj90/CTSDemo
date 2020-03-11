package com.digicom.onesqft.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    @SuppressLint("StaticFieldLeak")
    open lateinit var mContext: Context

    abstract fun onCreate(bundle: Bundle?)

    open fun onPause() {}

    open fun onResume() {}

    open fun startActivityForResult(requestCode: Int, resultCode: Int, data: Intent?) {
    }

    fun initContext(applicationContext: Context?) {
        mContext = applicationContext!!

    }

}