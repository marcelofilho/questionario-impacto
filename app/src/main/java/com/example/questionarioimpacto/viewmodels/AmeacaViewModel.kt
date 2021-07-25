package com.example.questionarioimpacto.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.questionarioimpacto.models.ThreatListModel
import com.example.questionarioimpacto.models.ThreatModel

class AmeacaViewModel: ViewModel() {



    init {

    }

     fun filtrarList(list: ThreatListModel, id: String): ArrayList<ThreatModel>{
        var threatList: ArrayList<ThreatModel> = ArrayList()
        list.listThreat?.forEach(){
            if(it.sectionId.equals(id))
                threatList.add(it)
        }
        return threatList
    }
}