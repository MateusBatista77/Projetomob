package com.example.projetomob.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetomob.R
import com.example.projetomob.model.TreinadorModelo

class treinadorAdapt(private val treiList: ArrayList<TreinadorModelo> ) :
    RecyclerView.Adapter<treinadorAdapt.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_treinador, parent, false)
            return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentTrei = treiList[position]
        holder.tvTreinome.text = currentTrei.nomeTreinador
    }

    override fun getItemCount(): Int {
       return treiList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTreinome :TextView =itemView.findViewById(R.id.tvTreinome)
    }

}
