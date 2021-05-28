package com.example.questionarioimpacto.models

import android.os.Parcel
import android.os.Parcelable


data class SectionModel(
        var title: String?,
        var id: String?): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SectionModel> {
        override fun createFromParcel(parcel: Parcel): SectionModel {
            return SectionModel(parcel)
        }

        override fun newArray(size: Int): Array<SectionModel?> {
            return arrayOfNulls(size)
        }
    }
}