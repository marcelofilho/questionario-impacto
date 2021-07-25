package com.example.questionarioimpacto.viewmodels

import androidx.lifecycle.ViewModel
import com.example.questionarioimpacto.models.QuestionListModel
import com.example.questionarioimpacto.models.QuestionModel
import java.util.ArrayList

class QuestoesViewModel: ViewModel() {


    init {

    }

     fun filtrarList(list: QuestionListModel, id: String): ArrayList<QuestionModel> {
        val questionList: ArrayList<QuestionModel> = ArrayList()
        list.questionList?.forEach(){
            if(it.sectionId.equals(id))
                questionList.add(it)
        }
        return questionList
    }

}