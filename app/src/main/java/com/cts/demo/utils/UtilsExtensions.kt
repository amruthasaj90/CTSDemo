package com.cts.demo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import com.squareup.moshi.Moshi

fun getBundleParcelableData(key: String, obj: Parcelable?): Bundle {
    val bundle = Bundle()
    bundle.putParcelable(key, obj)
    return bundle
}

fun addBundleParcelableData(bundle: Bundle, key: String, obj: Parcelable?): Bundle {
    bundle.putParcelable(key, obj)
    return bundle
}

fun isNetworkActive(context: Context?): Boolean {
    if (context == null) {
        return false
    }
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting
}

fun <T> T.moshiObjToString(type: Class<T>): String {
    val moshi = Moshi.Builder().build()
    val jsonAdapter = moshi.adapter(type)
    return jsonAdapter.toJson(this)
}

fun <T> String.moshiStringToObj(type: Class<T>): T? {
    val moshi = Moshi.Builder().build()
    val jsonAdapter = moshi.adapter(type)
    return jsonAdapter.fromJson(this)
}

fun TextInputLayout.enable() {
    this.isEnabled = true
}

fun TextInputLayout.disable() {
    this.isEnabled = false
}

fun View.enable() {
    this.isEnabled = true
    this.alpha = 1F
}

fun RadioGroup.disable() {
    this.isEnabled = false
    for (i in 0 until this.getChildCount()) {
        (getChildAt(i) as RadioButton).isEnabled = false
    }
}

fun RadioGroup.enable() {
    this.isEnabled = true
    for (i in 0 until this.getChildCount()) {
        (getChildAt(i) as RadioButton).isEnabled = true
    }
}

fun Spinner.enable() {
    this.isEnabled = true
}

fun Spinner.disable() {
    this.isEnabled = false
}

fun View.disable() {
    this.isEnabled = false
    this.alpha = 0.5F
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun TextView.setFontColor(colorId: Int) {
    this.setTextColor(
        ContextCompat.getColor(
            this.context,
            colorId
        )
    )
}

fun View.setBgColor(colorId: Int) {
    this.setBackgroundColor(
        ContextCompat.getColor(
            this.context,
            colorId
        )
    )
}

fun View.setBgResource(resId: Int) {
    this.setBackgroundResource(
        resId
    )
}



