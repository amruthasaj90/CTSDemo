package com.cts.demo.app

import android.app.Application
import com.cts.demo.webservice.base.RetrofitModules

class OneSqFtApp : Application() {

    override fun onCreate() {
        super.onCreate()

        RetrofitModules.init(applicationContext)
    }


}
