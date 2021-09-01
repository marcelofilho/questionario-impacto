package com.example.questionarioimpacto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.adapters.SectionAdapter.SectionHolder
import com.example.questionarioimpacto.models.SectionModel
import java.util.ArrayList

class SectionAdapter(private val listSection: ArrayList<SectionModel>?, private val mListenner: ItemClick) : RecyclerView.Adapter<SectionHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionHolder {
        return SectionHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SectionHolder, position: Int) {
        holder.bind(position, listSection!!,mListenner)
    }


    override fun getItemCount(): Int {
        return listSection!!.size!!
    }


    fun deleteItem(sectionID: String) {
        var position = getitem(sectionID)
        listSection?.removeAt(position)
        notifyItemRemoved(position)
        listSection?.size?.let { notifyItemRangeChanged(position, it) }

    }

    fun isEmpty(): Boolean {
        if (listSection!!.isEmpty())
            return true

       return false
    }

    fun getitem(sectionID: String): Int {
        var i = 0
        listSection?.forEach() {
            if (it.id?.equals(sectionID)!!)
                return i
            i++
        }
        return i
    }

     class SectionHolder private constructor(itemView: View) : ViewHolder(itemView) {
        val button: Button

        init {
            button = itemView.findViewById<View>(R.id.button_section) as Button
        }

       fun bind(
            position: Int,
            listSection: ArrayList<SectionModel>,
            mListenner: ItemClick
        ) {
            button.text = listSection.get(position).title
            button.setOnClickListener { mListenner.clickButton(listSection.get(position).id!!) }
        }
         companion object {
              fun from(parent: ViewGroup): SectionHolder {
                 return SectionHolder(
                     LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false)
                 )
             }
         }
    }



    interface ItemClick {
        fun clickButton(id: String)
    }


}