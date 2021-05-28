package com.example.questionarioimpacto.models

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.serialization.Serializable


data class QuestionIdModel(
        val dwellerId: String? = "",
        val questionPartId : String? = "",
        val texto: String? = "",
        val evaluationId : String? = ""
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dwellerId)
        parcel.writeString(questionPartId)
        parcel.writeString(texto)
        parcel.writeString(evaluationId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionIdModel> {
        override fun createFromParcel(parcel: Parcel): QuestionIdModel {
            return QuestionIdModel(parcel)
        }

        override fun newArray(size: Int): Array<QuestionIdModel?> {
            return arrayOfNulls(size)
        }
    }
}