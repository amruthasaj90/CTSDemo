package com.cts.demo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Categories(
    val contact: List<Contact>
) : Parcelable

@Parcelize
data class Contact(
    val number: String?=null,
    val type: String?=null
) : Parcelable