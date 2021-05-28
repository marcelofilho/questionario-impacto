package com.example.questionarioimpacto.models

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class QuestionListModel (val questionList: ArrayList<QuestionModel>?):Parcelable{
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(QuestionModel)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(questionList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionListModel> {
        override fun createFromParcel(parcel: Parcel): QuestionListModel {
            return QuestionListModel(parcel)
        }

        override fun newArray(size: Int): Array<QuestionListModel?> {
            return arrayOfNulls(size)
        }
    }

}