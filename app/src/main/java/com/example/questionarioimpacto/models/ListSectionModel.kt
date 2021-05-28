package com.example.questionarioimpacto.models

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class ListSectionModel(val listSection: ArrayList<SectionModel>?): Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(SectionModel)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(listSection)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ListSectionModel> {
        override fun createFromParcel(parcel: Parcel): ListSectionModel {
            return ListSectionModel(parcel)
        }

        override fun newArray(size: Int): Array<ListSectionModel?> {
            return arrayOfNulls(size)
        }
    }
}