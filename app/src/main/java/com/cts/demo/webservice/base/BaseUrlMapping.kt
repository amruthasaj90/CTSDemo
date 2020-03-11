package com.cts.demo.webservice.base

object BaseUrlMapping
{
    fun getUrl(feature: Feature): String {
        return when (feature) {
            Feature.DevUrl -> ""
            Feature.UatUrl -> ""
            Feature.LiveUrl -> ""
        }
    }
}

sealed class Feature
{
    object LiveUrl : Feature()
    object DevUrl : Feature()
    object UatUrl : Feature()
}