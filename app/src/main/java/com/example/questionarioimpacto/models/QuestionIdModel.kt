package com.example.questionarioimpacto.models

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.serialization.Serializable


data class QuestionIdModel(
        var dwellerId: String? = "",
        val questionPartId : String? = "",
        val texto: String? = "",
        val evaluationId : String? = ""
)
