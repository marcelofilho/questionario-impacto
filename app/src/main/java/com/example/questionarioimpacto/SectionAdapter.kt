package com.example.questionarioimpacto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.questionarioimpacto.SectionAdapter.SectionHolder
import com.example.questionarioimpacto.fragmentos.SecaoFragment
import com.example.questionarioimpacto.models.ListSectionModel

class SectionAdapter(private val listSection: ListSectionModel, private val mListenner: SecaoFragment) : RecyclerView.Adapter<SectionHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionHolder {
        return SectionHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false))
    }

    override fun onBindViewHolder(holder: SectionHolder, position: Int) {
        holder.button.text = listSection.listSection?.get(position)!!.title
        holder.button.setOnClickListener { mListenner.clickButton(listSection.listSection.get(position).id!!) }
    }

    override fun getItemCount(): Int {
        return listSection.listSection?.size!!
    }

    inner class SectionHolder(itemView: View) : ViewHolder(itemView) {
        val button: Button

        init {
            button = itemView.findViewById<View>(R.id.button_section) as Button
        }
    }

    fun deleteItem(sectionID: String) {
        var position = getitem(sectionID)
        listSection.listSection?.removeAt(position)
        notifyItemRemoved(position)
        listSection.listSection?.size?.let { notifyItemRangeChanged(position, it) }

    }

    fun isEmpty(): Boolean {
        if (listSection.listSection!!.isEmpty())
            return true

       return false
    }

    fun getitem(sectionID: String): Int {
        var i = 0
        listSection.listSection?.forEach() {
            if (it.id?.equals(sectionID)!!)
                return i
            i++
        }
        return i
    }


    interface ItemClick {
        fun clickButton(id: String)
    }
}