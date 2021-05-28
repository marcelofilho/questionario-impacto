package com.example.questionarioimpacto.models

data class AnswersModel(
        val questionId: String,
        val answerParts: List<AnswerParts>
){}