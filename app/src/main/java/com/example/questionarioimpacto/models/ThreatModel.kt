package com.example.questionarioimpacto.models

import android.os.Parcel
import android.os.Parcelable

class ThreatModel(var title: String?, val id: String?, val sectionId: String?):Parcelable {

    var isSCheck = false
        private set

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    fun setCheck(status: Boolean) {
        isSCheck = status
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(id)
        parcel.writeString(sectionId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ThreatModel> {
        override fun createFromParcel(parcel: Parcel): ThreatModel {
            return ThreatModel(parcel)
        }

        override fun newArray(size: Int): Array<ThreatModel?> {
            return arrayOfNulls(size)
        }
    }
}