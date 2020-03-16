package com.cts.demo.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.cts.demo.R


object AlertDialodUtil {

    interface DialogListener {
        fun onPositiveClicked()
        fun onNegativeClicked()
    }

    var alertDialog: AlertDialog? = null

    fun showNoNetworkAlert(context: Context) {
        if (alertDialog == null || !alertDialog!!.isShowing) {
            alertDialog = AlertDialog.Builder(context)
                .setCancelable(false)
                .setMessage(R.string.no_network)
                .setPositiveButton(context.getString(R.string.ok)) { dialog, _ -> dialog?.cancel() }
                .create()
            alertDialog?.setOnShowListener {

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
                .setPositiveButton(context.getString(R.string.ok)) { dialog, _ ->
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