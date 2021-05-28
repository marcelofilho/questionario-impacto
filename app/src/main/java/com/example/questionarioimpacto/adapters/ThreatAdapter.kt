package com.example.questionarioimpacto.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.questionarioimpacto.R
import com.example.questionarioimpacto.adapters.ThreatAdapter.ThreatHolder
import com.example.questionarioimpacto.models.ThreatModel

class ThreatAdapter(private val listThreat: List<ThreatModel>, private val mContext: Context, private val manipularListaQuestaoListenner: ManipularListaQuestaoListenner) : RecyclerView.Adapter<ThreatHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreatHolder {
        return ThreatHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false))
    }

    override fun onBindViewHolder(holder: ThreatHolder, position: Int) {
        holder.btn.text = listThreat[position].title
        holder.btn.setOnClickListener {
            if (!listThreat[position].isSCheck) {
                holder.btn.setBackgroundResource(R.drawable.bg_button_yellow)
                listThreat[position].setCheck(true)
            } else {
                holder.btn.setBackgroundResource(R.drawable.bg_button_square)
                listThreat[position].setCheck(false)
            }
        }
    }

    override fun getItemCount(): Int {
        return listThreat.size
    }

    inner class ThreatHolder(itemView: View) : ViewHolder(itemView) {
        var btn: Button

        init {
            btn = itemView.findViewById<View>(R.id.button_section) as Button
        }
    }

    interface ManipularListaQuestaoListenner{

        fun addList(id: String, iscHeck: Boolean)
        fun removeList()

    }
}