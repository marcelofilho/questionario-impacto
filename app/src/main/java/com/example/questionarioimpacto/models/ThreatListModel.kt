package com.example.questionarioimpacto.models

import android.os.Parcel
import android.os.Parcelable

class ThreatListModel(var listThreat: ArrayList<ThreatModel>?):Parcelable {

    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(ThreatModel)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(listThreat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ThreatListModel> {
        override fun createFromParcel(parcel: Parcel): ThreatListModel {
            return ThreatListModel(parcel)
        }

        override fun newArray(size: Int): Array<ThreatListModel?> {
            return arrayOfNulls(size)
        }
    }
}