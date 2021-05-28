package com.example.questionarioimpacto.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "section_table")

class SectionBDModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "question_name")
    val questionName: String,

    @ColumnInfo(name = "is_check")
    val isCheck: String,

    @ColumnInfo(name = "list_question")
    val listQuestion: List<QuestionIdModel>
)

