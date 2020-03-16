package com.cts.demo.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FactsResponse(
    var rows: List<Facts>?,
    var title: String? = ""
) : Parcelable

@Parcelize
data class Facts(
    var description: String? = "",
    var imageHref: String? = "",
    var title: String? = ""
) : Parcelable