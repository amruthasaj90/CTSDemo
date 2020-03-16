package com.cts.demo.webservice.base

object BaseUrlMapping
{
    fun getUrl(feature: Feature): String {
        return when (feature) {
            Feature.LiveUrl -> "https://dl.dropboxusercontent.com"
        }
    }
}

sealed class Feature
{
    object LiveUrl : Feature()
}