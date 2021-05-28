package com.example.questionarioimpacto.models

import android.os.Parcel
import android.os.Parcelable

class DwellerIdModel(val dwellerIdGenerate: String?):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dwellerIdGenerate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DwellerIdModel> {
        override fun createFromParcel(parcel: Parcel): DwellerIdModel {
            return DwellerIdModel(parcel)
        }

        override fun newArray(size: Int): Array<DwellerIdModel?> {
            return arrayOfNulls(size)
        }
    }
}