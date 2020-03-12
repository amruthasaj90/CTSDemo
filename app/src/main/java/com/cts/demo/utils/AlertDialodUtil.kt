package com.cts.demo.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager.widget.ViewPager
import com.cts.demo.R


object AlertDialodUtil {

    interface DialogListener {
        fun onPositiveClicked()
        fun onNegativeClicked()
    }

    interface DialogListenerItemClicked {
        fun onItemClicked(itemPosition:Int)
    }

    var alertDialog: AlertDialog? = null

    fun showNoNetworkAlert(context: Context) {
        if (alertDialog == null || !alertDialog!!.isShowing) {
            alertDialog = AlertDialog.Builder(context)
                    .setCancelable(false)
                    .setMessage("")
                    .setPositiveButton("") { dialog, _ -> dialog?.cancel() }
                    .create()
            alertDialog?.setOnShowListener {
               /* setFontStyle(
                        context,
                        alertDialog?.findViewById<TextView>(android.R.id.message),
                        false
                )
                setFontStyle(context, alertDialog?.getButton(Dialog.BUTTON_POSITIVE), true)*/
            }
            alertDialog?.show()
        }
    }

    fun showAlertMessage(
        context: Context,
        message: String,
        listener: AlertDialodUtil.DialogListener? = null
    ) {
        if (alertDialog == null || !alertDialog!!.isShowing) {
            alertDialog = AlertDialog.Builder(context)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton("") { dialog, _ ->
                    dialog?.cancel()
                    if (listener != null) {
                        listener.onPositiveClicked()
                    }
                }
                .create()
            alertDialog?.setOnShowListener {

            }

            alertDialog?.show()
        }
    }

}