package  com.cts.demo.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.cts.demo.R
import com.cts.demo.common.Constants
import com.cts.demo.model.ErrorResponse
import com.cts.demo.utils.AlertDialodUtil
import com.cts.demo.webservice.base.NetworkResult


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

    fun handleReponse(context: Activity, response: NetworkResult<Any>): Any? {

        when (response) {
            is NetworkResult.NoConnectionFailure -> {
                AlertDialodUtil.showNoNetworkAlert(context)
                return null
            }
            is NetworkResult.Successful -> {
                return response.value
            }
            is NetworkResult.Error -> {
                if (response.value is ErrorResponse) {
                    val err = response.value
                        AlertDialodUtil.showAlertMessage(
                            context,
                            "oops something went wroong!"
                        )
                    return null
                } else {
                    AlertDialodUtil.showAlertMessage(
                        context,
                        "oops something went wroong!"
                    )
                    return null
                }
            }
            else -> {
                AlertDialodUtil.showAlertMessage(
                    context,
                    "oops something went wroong!"
                )
                return null
            }
        }
    }

}