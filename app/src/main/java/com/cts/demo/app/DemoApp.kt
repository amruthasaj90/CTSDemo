package com.cts.demo.app

import android.app.Application
import com.cts.demo.utils.CodeSnippetExtension
import com.cts.demo.webservice.base.RetrofitModules

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        CodeSnippetExtension.init(applicationContext)
        RetrofitModules.init(applicationContext)
    }


}
